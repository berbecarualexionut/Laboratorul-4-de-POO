/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server.config;

import java.io.*;
import java.net.*;
import seriac.poo.structs.*;
import static seriac.poo.client.Client.getseriz;

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
        
        while(true){
        ObjectInputStream ois;
        ois = new ObjectInputStream(servsock.getInputStream());
        if(getseriz()){
        PrivateMessage msg;
        msg =(PrivateMessage) ois.readObject();
        System.out.println(msg);}
        else{
            Message msg1;
            msg1=(Message) ois.readObject();
            System.out.println(msg1);
        }
        }
    }
    
}
