package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Client2 {
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {
        int i = 0;
        Random random = new Random(2);

        ArrayList<Socket> sList = new ArrayList<>();
        while ( i  < 13_000){
            double number  = random.nextDouble(1.0, 1_000.0);
            try(Socket client = new Socket("localhost", 2123)){
                sList.add(client);
                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                outputStream.writeDouble(number);
                System.out.println("sent");
                DataInputStream inputStream = new DataInputStream(client.getInputStream());
                System.out.println(inputStream.readDouble());
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
            }
            i++;
        }
        System.out.println("List amount " + sList.size());
    }
}
