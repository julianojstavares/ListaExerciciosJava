/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class ClienteRMI_Mensagem {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, InterruptedException, IOException {
        
        RMIClient_Mensagem client = new RMIClient_Mensagem();
        client.conectar();
        
        
        // while (true)
        // {
        //     Scanner input = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        //     String texto = input.nextLine();
        //     client.getMensagemBuffer().put_mensagem("@Cliente: " + texto);
        //     // System.out.println(client.getMensagemBuffer().get_mensagem());
        // }

        List<String> buffer = new ArrayList<String>();
        String msg_servidor = "";
        String username = "";
        System.out.println("Digite seu nome de usuario");
        Scanner input_username = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        username = input_username.nextLine();
        System.out.println("Digite suas mensagens e pressione enter para enviar");
        
        while (true) 
        {
            buffer.add(client.getMensagemBuffer().get_mensagem());
            Thread.sleep(1000);
            buffer.add(client.getMensagemBuffer().get_mensagem());
            if(buffer.get(0) == buffer.get(1))
            {
                buffer.clear();
            }
            else
            {
                msg_servidor = buffer.get(1);
                // System.out.println(msg_servidor);
                buffer.clear();
            }
            // System.out.println(buffer.toString());
            Scanner input = new Scanner(new InputStreamReader(System.in, "UTF-8"));
            String texto = input.nextLine();
            client.getMensagemBuffer().put_mensagem(username + ": " + texto);
        }
    }
}
