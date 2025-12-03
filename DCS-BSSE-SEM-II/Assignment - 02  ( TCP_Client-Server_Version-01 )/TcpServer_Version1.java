import java.io.*;
import java.net.*;

public class TcpServer_Version1 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9090);
        System.out.println("\nServer started. Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!\n");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String received = dis.readUTF();
        System.out.println("Client said: " + received);

        String reply = "Server received your message: \"" + received + "\"";
        dos.writeUTF(reply);
        dos.flush();

        dis.close();
        dos.close();
        socket.close();
        server.close();

        System.out.println("Server closed.");
    }
}
