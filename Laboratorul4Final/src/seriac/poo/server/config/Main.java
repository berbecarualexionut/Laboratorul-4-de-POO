/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.server.config;
import java.io.*;
import java.lang.Exception.*;
import static java.lang.Integer.parseInt;
import java.net.*;
import java.util.Properties;
import static seriac.poo.server.config.ServerConfig.*;
import seriac.poo.server.exceptions.*;
/**
 *
 * @author student
 */
public class Main {
     
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        try{
        ServerConfig server = new ServerConfig();
        ServerSocket srv=new ServerSocket(server.getTcpPort());
        System.out.println("Waiting for a connection");
        Socket socket=srv.accept();
        System.out.println("Connected");
        ServerPeer peer=new ServerPeer(socket);
        while(true){
        peer.run();
        }
        
        
        }
        catch (IOException | MissingKeyException | UnknownKeyException | InvalidFormatException e) {
            e.printStackTrace();
        }
        
        
        
    }
}