
import clientserver_package.*;
import java.util.*;
import java.io.*;

public class FileServer
{

    public static void main(String[] args)
    {
        Server server = new Server(9090);
        System.out.println(server.startServer());
        System.out.println(server.acceptClient());

        boolean running = true;
        while (running)
        {
            String request = server.getRequest();
            running = !request.equalsIgnoreCase("quit");

            String response = handleRequest(request);
            server.sendResponse(response);
        }

        server.terminate_Server();
        System.out.println("\nClient Disconnected");
        System.out.println("Server shutting down...");
        System.out.println("Server closed!\n");
    }

    public static String handleRequest(String req)
    {
        String cmd = req.trim().toLowerCase();
        switch (cmd)
        {
            case "help" : return "<nl>COMMANDS:-                                          <nl>"
                                 + "<tab><tab>  |  HELP            -  List commands      |<nl>"
                                 + "<tab><tab>  |  FILES           -  List server files  |<nl>"
                                 + "<tab><tab>  |  GET <filename>  -  Read file          |<nl>"
                                 + "<tab><tab>  |  QUIT            -  Exit server        |<nl>";

            case "files": return listFiles();

            case "quit" : return "quit";

            default: if (cmd.startsWith("get ")) { return getFile(cmd.substring(4)); }
                     return "<nl>Invalid Command!  Type 'HELP'. <nl>";
        }

    }

    public static String listFiles()
    {
        File dir = new File(".");

        StringBuilder out = new StringBuilder("<nl>File list: ");
        File[] files = dir.listFiles();

    if (files == null) { return " Folder not accessible! <nl>" ; }

        out.append("<nl> ");
        int n = 1;
        for (File f : files)
        {
            out.append("<nl> ")
               .append(n++)
               .append(". ")
               .append( f.isFile() ? "[FIL] " : "[DIR] " )
               .append(f.getName());
        }
        out.append("<nl> ");
        return out.toString();

    }

    public static String getFile(String name)
    {
        File file = new File(name);

        if (!file.exists()) { return "File not found!<nl>"; }
        if (!file.isFile()) { return "Not a file!<nl>"; }

        StringBuilder content = new StringBuilder();

        try (Scanner s = new Scanner(file))
        {
            while (s.hasNextLine()) { content.append(s.nextLine()).append("<nl>"); }
        }
        catch (Exception e) { return e.toString(); }

        return content.toString();
    }

}
