import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class IOStart {

    public static void main(String[] args) {
//        File file = new File("file.txt");
//        if (!file.exists()) {
//            System.err.println("File does not exist");
//        }
//        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("data.dat")); Scanner scan = new Scanner(file)){
//            while(scan.hasNext()) {
//                out.write(scan.nextLine().getBytes());
//            }
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//        /*READING BYTE DATA*/
//        try(BufferedReader in = new BufferedReader(new FileReader("data.dat"))) {
//            System.out.println(in.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        start();
        try (DatagramSocket socket = new DatagramSocket(new InetSocketAddress(8484))) {
            DatagramPacket packet = new DatagramPacket(new byte[16], 16);
            socket.receive(packet);
        } catch (IOException _) {
        }

    }
}
