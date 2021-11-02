/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author felip
 */
public class RMIClient_Mensagem {
    static MensagemRMI_Interface mensagem;
    
    public void conectar() throws NotBoundException, MalformedURLException, RemoteException{
        
        System.setProperty("java.security.policy","file:./politicas.policy");
      //  if (System.getSecurityManager() == null)
      //      System.setSecurityManager(new RMISecurityManager());
        
        
        Registry registry =LocateRegistry.getRegistry("127.0.0.1", 5003);
        mensagem=(MensagemRMI_Interface) registry.lookup("MensagemService");
        
        //lista os servicos
        /*String[] servicos=registry.list();
        for(int i=0;i<servicos.length;i++){
            System.out.println(servicos[i]);
        }*/
        
        //System.out.println(mensagem.Hello());
    }   
    
    public MensagemRMI_Interface getMensagemBuffer(){
        return mensagem;
    }
}
