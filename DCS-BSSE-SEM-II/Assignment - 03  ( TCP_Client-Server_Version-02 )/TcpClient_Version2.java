
import java.io.*;
import java.net.*;

public class TcpClient_Version2 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9190);
        System.out.println("\nConnected to server!\n");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message, serverReply;

        System.out.println("Type your messages  ( or )  Type 'quit' to exit.\n");

        while (true) {
            System.out.print(" Client: ");
            message = userInput.readLine();
            out.println(message);

            if (message.equalsIgnoreCase("quit")) {
                break;
            }

            serverReply = in.readLine();

            if (serverReply == null) {
                System.out.println("\nServer is disconnected.");
                break;
            }

            System.out.println(" Server: " + serverReply);
        }

        in.close();
        out.close();
        socket.close();

        System.out.println("\nClient is disconnected. ");
    }
}

