import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876); // Port où le serveur écoute
            byte[] buffer = new byte[1024];
            System.out.println("Serveur UDP en attente de messages...");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message reçu : " + received);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

