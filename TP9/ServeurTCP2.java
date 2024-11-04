import java.io.*;
import java.net.*;

public class ServeurTCP2 {
    public static void main(String[] args) {
        try ( // Use a try-with-resources block for automatic resource management
            ServerSocket serverSocket = new ServerSocket(2016) // Create the server socket
        ) {
            System.out.println("Serveur en attente");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                System.out.println("Connexion d'un client.");

                try ( // Create another try-with-resources block for clientSocket and dIn
                    DataInputStream dIn = new DataInputStream(clientSocket.getInputStream())
                ) {
                    String received = dIn.readUTF();
                    System.out.println("Message: " + received);
                } catch (IOException e) {
                    System.err.println("Erreur lors de la lecture des données du client : " + e.getMessage());
                } finally {
                    clientSocket.close(); // Ensure clientSocket is closed even if an exception occurs
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
