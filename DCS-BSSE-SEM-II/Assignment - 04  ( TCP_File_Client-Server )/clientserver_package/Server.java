
package clientserver_package;

import java.io.*;
import java.net.*;

public class Server
{

    private int port;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public Server(int port) { this.port = port; }

    public String startServer()
    {
        try
        {
            serverSocket = new ServerSocket(port);
            return "\nServer started!";
        }
        catch (Exception e) { return e.toString(); }
    }

    public String acceptClient()
    {
        try
        {
            clientSocket = serverSocket.accept();
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            return "Client connected!\n";
        }
        catch (Exception e) { return e.toString(); }
    }

    public String getRequest()
    {
        try { return in.readLine(); }
        catch (Exception e) { return e.toString(); }
    }

    public void sendResponse(String msg) { out.println(msg); }

    public String terminate_Server()
    {
        try
        {
            clientSocket.close();
            serverSocket.close();
            return "Server closed!\n";
        }
        catch (Exception e) { return e.toString(); }
    }

}
