import java.io.*;
import java.net.*;

public class ClientTCP2 {
    public static void main(String[] args) {
        try {
            
            if (args.length == 0) {
                System.out.println("Argument.");
                return;
            }

            String message = args[0]; 

            Socket socket = new Socket("localhost", 2016);
            System.out.println("Connexion au serveur établie.");

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());

            dOut.writeUTF(message);
            System.out.println("Message envoyé : " + message);

            dOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
