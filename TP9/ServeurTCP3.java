import java.io.*;
import java.net.*;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2016)) {
            System.out.println("Serveur en attente");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion d'un client.");

                try (DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream())) {
                    String received = dIn.readUTF();
                    System.out.println("Message reçu : " + received);

                    // Inverser la chaîne
                    String reversed = new StringBuilder(received).reverse().toString();

                    // Envoyer la chaîne inversée au client
                    dOut.writeUTF(reversed);
                    System.out.println("Message envoyé (inversé) : " + reversed);
                } catch (IOException e) {
                    System.err.println("Erreur lors de la communication avec le client : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du serveur : " + e.getMessage());
        }
    }
}
