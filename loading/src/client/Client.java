package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Random;

/**
 *  Client class used to create a new client by dependency injection
 *  It is incomplete for now as I am yet to know how to create the socket port and proxy
*/
public class Client {

    static final Formatter fmt = new Formatter();

    static double generateDouble(){
        return  new Random().nextDouble(12.092, 1022.32);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            try(Socket client = new Socket("localhost", 3211)){
                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                double circle = generateDouble();
                outputStream.writeDouble(circle);
                // get the result
                DataInputStream inputStream = new DataInputStream(client.getInputStream());
                double result = inputStream.readDouble();
                System.out.println(fmt.format("from the server circle %1.4f has radius %1.4f\n", circle, result));
                fmt.flush();
            }
        }
    }
}
