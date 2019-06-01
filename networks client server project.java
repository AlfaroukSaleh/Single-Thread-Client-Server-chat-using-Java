/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;
import java.net.*;
import java.io.*;
/**
 *
 * @author Al-Farouk
 */
public class Client {
    
      public static void main (String args[]) throws Exception{
          Socket client = new Socket("localhost", 2000);
          BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
          PrintStream clientOut = new PrintStream(client.getOutputStream());
          BufferedReader clientTyping = new BufferedReader(new InputStreamReader(System.in));
          String string;
          while(true){
              System.out.print("Client: ");
              string = clientTyping.readLine();
              clientOut.println(string);
              string = clientIn.readLine();
              System.out.print("Server: " + string + "\n");
              if(string.equalsIgnoreCase("end session"))
                  break;
          }
          client.close();
          clientIn.close();
          clientOut.close();
          clientTyping.close();
      }
}
    
    

