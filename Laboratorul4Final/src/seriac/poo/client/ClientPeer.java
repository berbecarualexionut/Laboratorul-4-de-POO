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
    
    public String interogheaza(){
        return user;
    }
   
    void sendMessage(String message) throws IOException{
        
        try{
            
            ObjectOutputStream out=null;
            out=new ObjectOutputStream(clientsoc.getOutputStream());
            
            Message msg=new Message(user,message);
            out.writeObject(msg);
            
            
            
        }
        catch(SocketException e){
            e.printStackTrace();
            
        }
    }
    
    void sendMessage(String message,String recipient) throws IOException{
           
            ObjectOutputStream out=null;
        try{
            out=new ObjectOutputStream(clientsoc.getOutputStream());
            
            PrivateMessage privmsg=new PrivateMessage(user,message,recipient);
            out.writeObject(privmsg);
            }
        catch(SocketException e){
            e.printStackTrace();
        }
        finally{
            try{
                out.close();
               
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
