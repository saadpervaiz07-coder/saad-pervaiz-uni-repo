
package clientserver_package;

import java.io.*;
import java.net.*;

public class Client
{

    private String ip;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public String connectServer()
    {
        try
        {
            socket = new Socket(ip, port);
            in     = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out    = new PrintWriter(socket.getOutputStream(), true);
            return "\nConnected to the server! \n\nType 'HELP' for commands. ";
        }
        catch (Exception e) { return e.toString(); }
    }

    public void sendRequest(String msg) { out.println(msg); }

    public String getResponse()
    {
        try { return in.readLine(); }
        catch (Exception e) { return e.toString(); }
    }

    public String terminate_Client()
    {
        try
        {
            socket.close();
            return "\nClient closed! \n";
        }
        catch (Exception e) { return e.toString(); }
    }

}


