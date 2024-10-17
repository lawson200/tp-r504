import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            String s = "Hello World";
            byte[] data = s.getBytes();

            InetAddress address = InetAddress.getByName("localhost"); // Adresse IP du serveur
            DatagramPacket packet = new DatagramPacket(data, data.length, address, 9876);
            socket.send(packet);
            System.out.println("Message envoyé : " + s);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

