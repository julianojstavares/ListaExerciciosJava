package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MODEL.Cliente;
import MODEL.FormaPagamento;
import MODEL.ItemPedido;
import MODEL.Livro;
import MODEL.Pedido;

public class PedidoDAO {

	private static String tbName ="tb_pedido";
	private static String tbItens ="tb_itens_pedido";
	private static String SELECT = String.format("SELECT * FROM %1$s", PedidoDAO.tbName);
	private static String SELECTBYPK =  String.format("SELECT * FROM %1$s WHERE id=?", PedidoDAO.tbName);
	private static String INSERT =  String.format("INSERT INTO %1$s (id_cliente, numero, data_venda,forma_pagamento) VALUES(?,?,?,?)", PedidoDAO.tbName); 
	private static String DELETE =  String.format("DELETE FROM %1$s where id = ?", PedidoDAO.tbName);
	private static String UPDATE =  String.format("UPDATE %1$s SET id_cliente =?, numero?, data_venda = ?, forma_pagamento = ? where id = ?", PedidoDAO.tbName);
	private static String SELECTITENS = String.format("SELECT * FROM %1$s where id_pedido = ?",PedidoDAO.tbItens);
	private static String INSERTITEM = String.format("INSERT INTO %1$s (id_pedido, id_livro, perc_desconto,quantidade) VALUES(?,?,?,?)",PedidoDAO.tbItens); 
	private static String DELETEITENS = String.format("DELETE FROM %1$s where id_pedido = ?",PedidoDAO.tbItens);
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private LivroDAO livroDAO = new LivroDAO();
	
	public boolean inserir(Pedido pedido){

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int result1 = 0;
		int result2 = 0;
		try {
			// insere o pedido
			ps = DaoUtils.getConnection().prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			Cliente cliente = pedido.getCliente();
			if (cliente != null) {
				ps.setLong(1, cliente.getId());
				ps.setLong(2, pedido.getNumero());
				ps.setDate(3, new java.sql.Date(pedido.getDataVenda().getTime()));
				ps.setLong(4, pedido.getFormaPagamento().ordinal());
				result1= ps.executeUpdate();
				ResultSet idOrdemVenda= ps.getGeneratedKeys();
				idOrdemVenda.next();
				int idOV = idOrdemVenda.getInt("id");
				ps2 = DaoUtils.getConnection().prepareStatement(INSERTITEM);
				// insere os itens do pedido
				for (ItemPedido item : pedido.getItens()) {
					Livro livro = item.getLivro();
					if (livro != null) {
						ps2.setLong(1, idOV);
						ps2.setLong(2, livro.getId());
						ps2.setInt(4, item.getQuantidade());
						result2 += ps2.executeUpdate();

						Livro livroTemp = new Livro();
						livroTemp = livroDAO.selectByPk((int) livro.getId());
						livroTemp.setQuantidadeEstoque(livroTemp.getQuantidadeEstoque() - item.getQuantidade());
						livroDAO.atualizar(livroTemp);
					}
				}
			}
			return result1 + result2 > 0;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		} finally {
			DaoUtils.fechaConexoes(conn, ps, null);
			DaoUtils.fechaConexoes(conn, ps2, null);
		}
	}
	
	public boolean atualizar(Pedido pedido) {

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		try {
			// atualiza o pedido
			ps = DaoUtils.getConnection().prepareStatement(UPDATE);
			Cliente cliente = pedido.getCliente();
			if (cliente != null) {
				ps.setLong(1, cliente.getId());
				ps.setLong(2, pedido.getNumero());
				ps.setDate(3,new java.sql.Date(pedido.getDataVenda().getTime()));
				ps.setLong(4, pedido.getFormaPagamento().ordinal());
				ps.setLong(5, pedido.getId());
				result1= ps.executeUpdate();
			
				// deleta os itens do pedido para reinseri-los
				ps2 = DaoUtils.getConnection().prepareStatement(DELETEITENS);
				ps2.setLong(1, pedido.getId());
				result2 = ps2.executeUpdate();
				
				// insere os itens do pedido novamente
				ps3 = DaoUtils.getConnection().prepareStatement(INSERTITEM);
				for (ItemPedido item : pedido.getItens()) {
					Livro livro = item.getLivro();
					if (livro != null) {
						ps3.setLong(1, pedido.getId());
						ps3.setLong(2, livro.getId());
						ps3.setInt(4, item.getQuantidade());
						result3 += ps3.executeUpdate();
					}
				}
			}
			return result1 + result2+ result3 > 0;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		} finally {
			DaoUtils.fechaConexoes(conn, ps, null);
			DaoUtils.fechaConexoes(conn, ps2, null);
			DaoUtils.fechaConexoes(conn, ps3, null);
		}
	}
	
	public void deletar(int id) {

		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			conn = DaoUtils.getConnection();
			
			// deletar os itens do pedido
			ps1 = DaoUtils.getConnection().prepareStatement(DELETEITENS);
			ps1.setLong(1,id);
			ps1.executeUpdate();
			
			// deletar o pedido
			ps2 = conn.prepareStatement(DELETE);
			ps2.setLong(1, id);
			ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoUtils.fechaConexoes(conn, ps1, null);
			DaoUtils.fechaConexoes(conn, ps2, null);
		}
	}	
	
	public ArrayList<Pedido> carregaLista() throws Exception {

		Connection conn = DaoUtils.getConnection();
		PreparedStatement ps1 = conn.prepareStatement(SELECT);
		PreparedStatement ps2 = conn.prepareStatement(SELECTITENS);
		ResultSet rsItens = null;
		ResultSet rsPedido = ps1.executeQuery();	
		ArrayList<Pedido> pedidos = new ArrayList<>();
		while (rsPedido.next()) {
			//obt??m o cliente do pedido
			Cliente cliente = clienteDAO.selectByPk(rsPedido.getInt("id_cliente"));
			if (cliente != null) {
				// carrega dados do pedido
				Pedido pedido = new Pedido();
				pedido.setId(rsPedido.getLong("id"));
				pedido.setCliente(cliente);
				pedido.setNumero(rsPedido.getLong("numero"));
				pedido.setDataVenda(new java.util.Date(rsPedido.getDate("data_venda").getTime()));
				pedido.setFormaPagamento(FormaPagamento.values()[rsPedido.getInt("forma_pagamento")]);
				
				// carrega itens do pedido
				ArrayList<ItemPedido> itens = new ArrayList<>();
				ps2.setLong(1, rsPedido.getLong("id"));
				rsItens = ps2.executeQuery();	
				while (rsItens.next()) {
					Livro livro = livroDAO.selectByPk(rsItens.getInt("id_livro"));
					if (livro != null) {
						ItemPedido item = new ItemPedido();
						item.setId(rsItens.getLong("id"));
						item.setLivro(livro);
						item.setQuantidade(rsItens.getInt("quantidade"));
						itens.add(item);
					}	
				}
				pedido.setItens(itens);
				pedidos.add(pedido);
				pedido = null;
			}
		}
		DaoUtils.fechaConexoes(conn, ps1, rsPedido);
		DaoUtils.fechaConexoes(conn, ps2, rsItens);
		return pedidos;
	}
	
	public Pedido selectByPk(int id) {

		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rsPedido = null;
		ResultSet rsItens = null;
		Pedido pedido = null;
		try {
			conn = DaoUtils.getConnection();
			ps1 = conn.prepareStatement(SELECTBYPK);
			ps2 = conn.prepareStatement(SELECTITENS);
			ps1.setInt(1, id);
			rsPedido = ps1.executeQuery();
			if (rsPedido.next()) {
				//obt??m o cliente do pedido
				Cliente cliente = clienteDAO.selectByPk(rsPedido.getInt("id_cliente"));
				if (cliente != null) {
					// carrega dados do pedido
					pedido = new Pedido();
					pedido.setId(rsPedido.getLong("id"));
					pedido.setCliente(cliente);
					pedido.setNumero(rsPedido.getLong("numero"));
					pedido.setDataVenda(new java.util.Date(rsPedido.getDate("data_venda").getTime()));
					pedido.setFormaPagamento(FormaPagamento.values()[rsPedido.getInt("forma_pagamento")]);
					
					// carrega itens do pedido
					ArrayList<ItemPedido> itens = new ArrayList<>();
					ps2.setLong(1, rsPedido.getLong("id"));
					rsItens = ps2.executeQuery();	
					while (rsItens.next()) {
						Livro livro = livroDAO.selectByPk(rsItens.getInt("id_livro"));
						if (livro != null) {
							ItemPedido item = new ItemPedido();
							item.setId(rsItens.getLong("id"));
							item.setLivro(livro);
							item.setQuantidade(rsItens.getInt("quantidade"));
							itens.add(item);
						}	
					}
					pedido.setItens(itens);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoUtils.fechaConexoes(conn, ps1, rsPedido);
			DaoUtils.fechaConexoes(conn, ps2, rsItens);
		}
		return pedido;
	}
}