
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public  class filereader {

    public static void main (String[] args)
    {
        try
        {
            String fileName = "EVE01Sales (2).txt";
            System.out.println("\n\n\t   " + fileName + "\n");

            FileReader file = new FileReader(fileName);
            BufferedReader br = new BufferedReader(file);

            System.out.println("----- File Content Start -----");

            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
            System.out.println("----- File Content End -----");
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    }


