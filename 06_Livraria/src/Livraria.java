import java.util.Scanner;

public class Livraria {
    public static void main(String[] args) throws Exception {
        /*
        Criar um livro.
        Criar um autor, e vincular ao livro
        Criar um publicador, e vincular ao livro
        Criar um usuário(Editorial/Consumidor), e vincular a ordem de compra
        Criar um Entregador.
        Criar InformacoesDeEntrega e vincular o entregador.
        Criar uma conta
        Criar um classe de Informacoes de compra e vincular a Conta
        Vincular tudo acima.
        temos um objeto de venda.
        Criar uma ordem de compra
        */
        Book milEUmaNoites = new Book();
        
        Author mohammedAli = new Author();
        milEUmaNoites.setAuthor(mohammedAli);
        
        Publisher dasArabias = new Publisher();
        milEUmaNoites.setPublisher(dasArabias);
        
        User joaoComprador = new User();
        // User zePitaco = new Editorial();
        // User zeCompreiMasNaoLi = new Customer();
        
        Shipper entregaJa = new Shipper();
        ShippingInfo infoEntrega = new ShippingInfo();
        infoEntrega.setShipper(entregaJa);
        
        Account contaJoao = new Account();
        joaoComprador.setAccount(contaJoao);
        contaJoao.setId(1);
        contaJoao.setPassword("123");
        contaJoao.setEmailAddress("joao@email.com");

        BillingInfo infoCompra = new BillingInfo();
        infoCompra.setAccount(contaJoao);

        Order compra123 = new Order();
        compra123.setUser(joaoComprador);
        compra123.setBook(milEUmaNoites);
        compra123.setShippingInfo(infoEntrega);
        compra123.setBillingInfo(infoCompra);
        if(compra123.isFullfilled())
        {
            Scanner scannerId;
            int id = 0;
            String psw = "";
            try {
                scannerId = new Scanner(System.in);
                System.out.println("Manda o id pa noix");
                id = scannerId.nextInt();
                System.out.println("Manda a senha pa noix");
                psw = scannerId.next();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(compra123.getBillingInfo().getAccount().validateLogin(id, psw))
            {
                System.out.println("Parabéns amiguinho, você comprou seu livrinho :)");
            }
        }
    }
}
