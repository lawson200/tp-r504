import java.io.*;
import java.net.*;

public class ServeurTCP1
{
    public static void main(String[] args) 
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(2016);
            System.out.println("Serveur en attente");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connexion d'un client.");

            DataInputStream dIn = new DataInputStream(clientSocket.getInputStream());

            String received = dIn.readUTF();
            System.out.println("Message: " + received);

            dIn.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
