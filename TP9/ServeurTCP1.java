import java.io.*;
import java.net.*;

public class ServeurTCP
{
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(2016); // Crée un serveur sur le port 2016
            System.out.println("Serveur TCP en attente");
            
            Socket clientSocket = serverSocket.accept(); // Accepte la connexion du client
            System.out.println("Connexion d'un client.");

            // Crée un flux de données pour lire les informations envoyées par le client
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // Lecture de données envoyées par le client
            String received = in.readUTF(); // Lire une chaîne de caractères UTF-8
            System.out.println("Message: " + dIn.readUTF());

            in.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}

