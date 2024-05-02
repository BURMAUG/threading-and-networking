package networking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(2123)){
           while (true){
                // accept the clients request
               Socket serverSocket = server.accept();
               try {
                   DataInputStream inputStream = new DataInputStream(serverSocket.getInputStream());
                   System.out.println(inputStream.readDouble());
                   DataOutputStream outputStream = new DataOutputStream(serverSocket.getOutputStream());
                   outputStream.writeDouble(23.32 );
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
           }
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
