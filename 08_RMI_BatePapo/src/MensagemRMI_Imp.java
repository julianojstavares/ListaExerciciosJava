/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;


/**
 *
 * @author felip
 */
public class MensagemRMI_Imp implements MensagemRMI_Interface {

    // private static final long serialVersionUID=1L;
    
    String mensagem;

    
    protected MensagemRMI_Imp(String mensagem) throws RemoteException{
        super();
    }

    @Override
    public void put_mensagem(String txt) 
    {
        mensagem = txt;
    }
    
    @Override
    public String get_mensagem()
    {
        return mensagem;
    }    
}

