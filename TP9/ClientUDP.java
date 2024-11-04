import java.io.*;
import java.net.*;

public class ClientUDP {
  public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket();
      String message = "Hello World";
      byte[] data = message.getBytes();

      InetAddress address = InetAddress.getByName("localhost");
      DatagramPacket packet = new DatagramPacket(data, data.length, address, 9876);
      socket.send(packet);
      System.out.println("Message envoyé : " + message);

      // Nouveau code pour recevoir la réponse
      byte[] buffer = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
      socket.receive(receivePacket);
      String received = new String(receivePacket.getData(), 0, receivePacket.getLength());
      System.out.println("Message reçu du serveur : " + received);

      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
