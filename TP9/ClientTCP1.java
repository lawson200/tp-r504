import java.io.*;
import java.net.*;

public class ClientTCP1
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 2016); // Connecte le client au serveur à l'adresse localhost et au port 2016
            System.out.println("Connexion au serveur établie.");

            // Crée un flux de données pour envoyer des informations au serveur
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            // Envoie une chaîne de caractères UTF-8 au serveur
            String message = "Bonjour, serveur !";
            dOut.writeUTF("message test"); // Écrire une chaîne de caractères
            System.out.println("Message envoyé : " + message);

            dOut.close();
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

