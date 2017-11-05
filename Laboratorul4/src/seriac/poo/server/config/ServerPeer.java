/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server.config;

import java.io.*;
import java.net.*;
import seriac.poo.structs.Message;

/**
 *
 * @author Alex
 */
public class ServerPeer {
    Socket servsock;
    public ServerPeer(Socket soc){
        servsock=soc;
    }
    
    void run() throws IOException, ClassNotFoundException{
        
        
        ObjectInputStream ois;
        ois = new ObjectInputStream(servsock.getInputStream());
        Message msg;
        msg =(Message) ois.readObject();
        System.out.println(msg);
        
    }
    
}
