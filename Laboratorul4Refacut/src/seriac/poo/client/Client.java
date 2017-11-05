/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriac.poo.client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Client {
    public String utilizator;
    
    
    
    
    
    
    
    public static void main(String[] args) throws IOException{
        Client c=new Client();
        Scanner scn=new Scanner(System.in);
        c.utilizator=scn.next();
        Socket socket=new Socket("127.0.0.1",9000);
        ClientPeer cp=new ClientPeer(c.utilizator,socket);
        String reader=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while((reader=br.readLine())!="/q"){
        if(reader.startsWith("/w")){
        char a=' ';
        int b=reader.indexOf(a);
        int l=reader.lastIndexOf(a);
        String msg=reader.substring(b+1, l+1);
        String recip=reader.substring(l+1);
        cp.sendMessage(msg,recip);
        }  
        else{
        char a=' ';
        int b=reader.indexOf(a);
        String msg=reader.substring(b+1);
        cp.sendMessage(msg);
        }
            
            
        }
    }
    
    
}
