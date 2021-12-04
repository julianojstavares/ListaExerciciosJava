package BLL;

import DAO.PedidoDAO;
import MODEL.Pedido;

public class venda {
   
    public void vender(Pedido pedido) {
        if(pedido.getCliente() != null && pedido.getItens() != null) 
        {
            if(pedido.getItens().size() > 0)
            {
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedidoDAO.inserir(pedido);
            }
        }
    }
}
