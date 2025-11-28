import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9190);
        System.out.println("Connected to server...");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message;
        String serverReply;

        System.out.println("Type your messages. Type 'quit' to exit.");

        while (true) {
            System.out.print("fabha: ");
            message = userInput.readLine();
            out.println(message);

            if (message.equalsIgnoreCase("quit")) {
                break;
            }
            serverReply = in.readLine();
            if (serverReply == null) {
                System.out.println("Server disconnected.");
                break;
            }
            System.out.println("irtiza: " + serverReply);
        }

        in.close();
        out.close();
        socket.close();
        System.out.println("Client disconnected.");
    }
}
