
import java.io.*;
import java.net.*;

public class TcpServer_Version2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9190);
        System.out.println("\nServer is started...  Waiting for the client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("\nClient is connected!\n");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

        String message;

        while ((message = in.readLine()) != null) {
            System.out.println(" Client: " + message);

            if (message.equalsIgnoreCase("quit")) {
                System.out.println("\nClient ended the chat. Therefore... ");
                break;
            }

            System.out.print(" Server: ");
            String reply = serverInput.readLine();
            out.println(reply);
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();

        System.out.println("\nThe Server is stopped. ");
    }
}

