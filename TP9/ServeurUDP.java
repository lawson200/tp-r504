import java.io.*;
import java.net.*;

public class ServeurUDP {
  public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket(9876);
      byte[] buffer = new byte[1024];
      System.out.println("Serveur UDP en attente de messages...");

      while (true) {
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivePacket);
        String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Message reçu : " + received);

        // Création d'un datagramme de réponse
        InetAddress address = receivePacket.getAddress();
        int port = receivePacket.getPort();
        byte[] data = received.getBytes();
        DatagramPacket responsePacket = new DatagramPacket(data, data.length, address, port);
        socket.send(responsePacket);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
