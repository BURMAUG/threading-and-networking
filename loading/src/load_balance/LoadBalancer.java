package load_balance;

import server_a.Server_A;
import server_b.Server_B;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/***
 * Load Balancer is a server that direct traffic  from clients to various servers for processing in a Round-Robin
 * fair manner.
 */
public class LoadBalancer {
//    int current_count = 0;  // this should be the current
    // A queue for each server
    LinkedList<Double> server_a_queue = new LinkedList<>();
    LinkedBlockingQueue<Double> server_b_queue = new LinkedBlockingQueue<>();
    private Server_A server_a;
    private Server_B server_b;

    public static void main(String[] args) throws IOException {
        while (true) {
            try (ServerSocket lb = new ServerSocket(3211)){
                Socket socket = lb.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                double c = inputStream.readDouble();
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeDouble(2 * Math.PI * Math.pow(c, 2));
            }
        }
    }

    /***
     *
     */
    private void roundRobin(){
        if (server_a_queue.size() == server_b_queue.size()){
//            server_a_queue.add()
        }
    }
}