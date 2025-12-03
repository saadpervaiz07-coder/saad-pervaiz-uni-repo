import java.io.*;
import java.net.*;

public class TcpClient_Version1 {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 9090);

		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("\nEnter message for server: ");
		String message = br.readLine();

		dos.writeUTF(message);
		dos.flush();

		String response = dis.readUTF();
		System.out.println("Server replied: " + response);

		br.close();
		dis.close();
		dos.close();
		socket.close();
	}
}
