
import clientserver_package.*;
import java.util.*;

public class FileClient
{

    public static void main(String[] args)
    {
        Client client = new Client("localhost", 9090);
        System.out.println(client.connectServer());

        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running)
        {
            System.out.print("\nEnter the command: ");
            String cmd = input.nextLine();

            if (cmd.startsWith("get ")){ System.out.println(); }

            client.sendRequest(cmd);
            String response = client.getResponse();

            if (response.equalsIgnoreCase("quit"))
            {
                running = false;
                //System.out.println(format(response));  // show final messages
                System.out.println("\nClient Disconnected\nServer shutting down...\nClosing...\n\n\nExited Server Successfully!\n");
            }
            else
            {
                System.out.println(format(response));
            }

        }
        client.terminate_Client();
        input.close();

    }

    private static String format(String txt)
    {
        txt = txt.replace("<nl>" , "\n");
        txt = txt.replace("<tab>", "\t");
        return txt;
    }


}

