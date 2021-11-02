import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author felip
 */
public class PrincipalCliente {

    public static void main(String[] args) {
        ClienteProdutor clienteProdutor = null;
        ClienteConsumidor clienteConsumidor;

        MensagemBuffer mensagensClienteEnvio = new MensagemBuffer(10);
        MensagemBuffer mensagensClienteRecepcao = new MensagemBuffer(10);
        ClienteSocket clienteSocket = new ClienteSocket("127.0.0.1", 8889);

        clienteSocket.conect();

        if (clienteSocket.getSocket() != null) {
            clienteConsumidor = new ClienteConsumidor(mensagensClienteRecepcao, clienteSocket.getSocket());
            clienteProdutor = new ClienteProdutor(mensagensClienteEnvio, clienteSocket.getSocket());

        }

        Scanner leitor = new Scanner(System.in);

        while (true) {
            String texto = leitor.next();
            clienteProdutor.enviarMensagem("Cliente: @ " + texto);
            
            // System.out.println(mensagensClienteRecepcao.get());
            String [] dados = mensagensClienteRecepcao.get().split("@");
            System.out.println("Nome: " + dados[0] + "  " + "Mensagem: " + dados[1]);
            // System.out.println(mensagensClienteRecepcao.get());
        }

    }
}
