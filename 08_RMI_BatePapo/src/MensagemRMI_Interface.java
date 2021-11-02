/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author felip
 */
public interface MensagemRMI_Interface extends Remote {    
    
    public void put_mensagem(String txt) throws RemoteException;
    public String get_mensagem() throws RemoteException;
}
