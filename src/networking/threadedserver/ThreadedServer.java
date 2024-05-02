package networking.threadedserver;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServer extends Thread{
    public final Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Integer id;

    public ThreadedServer(Socket socket, Integer id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run(){
            try {
                inputStream = new DataInputStream(socket.getInputStream());
                InetAddress address = socket.getInetAddress();
                System.out.println("Client_" + id+ " " + address.getAddress()[0] + " " + address.getAddress()[1] + " " + address.getAddress()[2] +  " " + address.getAddress()[3]);
                double radius = inputStream.readDouble();

                // Write back to the client
                outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeDouble(radius * 2 * Math.PI );

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    public static void main(String[] args) {
        try(ExecutorService executorService = Executors.newFixedThreadPool(12);ServerSocket serverSocket  = new ServerSocket(8121)){
            int id = 0;

            while (true){
                Socket socket1 = serverSocket.accept();
                Thread thread = new ThreadedServer(socket1, id);
//                thread.start();
                executorService.execute(thread);
                id++;
            }
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
