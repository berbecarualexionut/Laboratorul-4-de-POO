/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.io.*;
import java.net.*;
import seriac.poo.structs.*;

/**
 *
 * @author Alex
 */
public class ClientPeer  {
    String user;
    Socket clientsoc;
    
    public ClientPeer(String util,Socket soc){
        user=util;
        clientsoc=soc;
    }
   
    void sendMessage(String message) throws IOException{
        
        try{
            ObjectInputStream in=null;
            ObjectOutputStream out=null;
            out=new ObjectOutputStream(clientsoc.getOutputStream());
            in=new ObjectInputStream(clientsoc.getInputStream());
            Message msg=new Message(user,message);
            out.writeObject(msg);
            
            
            
        }
        catch(SocketException e){
            e.printStackTrace();
            
        }
    }
    
    void sendMessage(String message,String recipient) throws IOException{
        try{
            ObjectInputStream in=null;
            ObjectOutputStream out=null;
            out=new ObjectOutputStream(clientsoc.getOutputStream());
            in=new ObjectInputStream(clientsoc.getInputStream());
            PrivateMessage privmsg=new PrivateMessage(user,message,recipient);
            out.writeObject(privmsg);
            }
        catch(SocketException e){
            e.printStackTrace();
        }
    }
}
