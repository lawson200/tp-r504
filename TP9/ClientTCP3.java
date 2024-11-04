import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        try {
            // Vérifie si un message a été fourni en argument
            if (args.length == 0) {
                System.out.println("S'il te plaît, donne-moi un mot pour l'envoyer au serveur !");
                return;
            }

            String message = args[0];

            // Se connecte au serveur
            Socket socket = new Socket("localhost", 2016);
            System.out.println("Connecté au serveur !");

            // Envoie le message au serveur
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(message);
            System.out.println("J'ai envoyé : " + message);

            // Reçoit le message inversé du serveur
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String messageInverse = dIn.readUTF();
            System.out.println("Le serveur m'a renvoyé : " + messageInverse);

            // Ferme les flux et la socket
            dOut.close();
            dIn.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Oups, il y a eu une erreur : " + e.getMessage());
        }
    }
}
