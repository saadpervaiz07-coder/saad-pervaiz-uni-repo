import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9190);
        System.out.println("Server started... waiting for client");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("ali: " + message);

            if (message.equalsIgnoreCase("quit")) {
                break;
            }

            System.out.print("irtiza: ");
            String reply = serverInput.readLine();
            out.println(reply);
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
