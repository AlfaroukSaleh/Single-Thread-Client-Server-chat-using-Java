package server;
import java.net.*;
import java.io.*;
/**
 *
 * @author Al-Farouk
 */
public class Server {

    public static void main(String args[]) throws Exception{
        ServerSocket server = new ServerSocket(2000);
        Socket client = server.accept();
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintStream serverMessage = new PrintStream(client.getOutputStream());
        BufferedReader serverTyping = new BufferedReader(new InputStreamReader(System.in));
        String string;
        while(true){
            string = clientIn.readLine();
            if(string.equalsIgnoreCase("end session")){
                serverMessage.print("Ok, Bye.\n");
                break;
            }
            System.out.println("Rooka: " + string);
            System.out.print("Server: ");
            string = serverTyping.readLine();
            serverMessage.println(string);
        }
        server.close();
        client.close();
        clientIn.close();
        serverTyping.close();
        serverMessage.close();        
    }
}