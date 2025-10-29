
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SummaryForSales
{
    public static void main(String[] args)
    {
        String fileName = "EVE01Sales.txt";
        double totalSales = 0;
        double e011 = 0, e012 = 0, e013 = 0, e014 = 0;
        double prodA = 0, prodB = 0, prodC = 0, prodD = 0;
        double north = 0, south = 0, east = 0, west = 0;
        double june = 0, july = 0, august = 0;

        SimpleDateFormat f1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat f2 = new SimpleDateFormat("MMM-dd-yy", Locale.ENGLISH);
        SimpleDateFormat fm = new SimpleDateFormat("MMMM", Locale.ENGLISH);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line = br.readLine();
            line = br.readLine();
            while (line != null)
            {
                String[] d = line.split("\\t");
                if (d.length >= 6)
                {
                    try
                    {
                        String dateStr = d[0].trim();
                        String region = d[1].trim();
                        String rep = d[2].trim();
                        String product = d[3].trim();

                        int    qty = Integer.parseInt(d[4].trim());
                        double price = Double.parseDouble(d[5].trim());
                        double sale = qty * price;
                               totalSales += sale;

                             if (rep.equalsIgnoreCase("E011")) e011 += sale;
                        else if (rep.equalsIgnoreCase("E012")) e012 += sale;
                        else if (rep.equalsIgnoreCase("E013")) e013 += sale;
                        else if (rep.equalsIgnoreCase("E014")) e014 += sale;

                             if (product.equalsIgnoreCase("Product A")) prodA += sale;
                        else if (product.equalsIgnoreCase("Product B")) prodB += sale;
                        else if (product.equalsIgnoreCase("Product C")) prodC += sale;
                        else if (product.equalsIgnoreCase("Product D")) prodD += sale;

                             if (region.equalsIgnoreCase("North")) north += sale;
                        else if (region.equalsIgnoreCase("South")) south += sale;
                        else if (region.equalsIgnoreCase("East"))  east += sale;
                        else if (region.equalsIgnoreCase("West"))  west += sale;

                        try
                        {
                            Date date;

                            if (dateStr.matches("\\d{1,2}-[A-Za-z]{3}-\\d{4}"))
                                date = f1.parse(dateStr);
                            else
                                date = f2.parse(dateStr);

                            String month = fm.format(date);

                                 if (month.equalsIgnoreCase("June"))   june += sale;
                            else if (month.equalsIgnoreCase("July"))   july += sale;
                            else if (month.equalsIgnoreCase("August")) august += sale;
                        }
                        catch (ParseException e) { }
                    }
                    catch (NumberFormatException e) { }
                }
                line = br.readLine();
            }

            System.out.println("\n\nTotal Sales Amount = " + totalSales);

            System.out.println("\n Employee-wise Sales:\n");
            System.out.println("\tE011 = " + e011);
            System.out.println("\tE012 = " + e012);
            System.out.println("\tE013 = " + e013);
            System.out.println("\tE014 = " + e014);

            System.out.println("\n Product-wise Sales:\n");
            System.out.println("\tProduct A = " + prodA);
            System.out.println("\tProduct B = " + prodB);
            System.out.println("\tProduct C = " + prodC);
            System.out.println("\tProduct D = " + prodD);

            System.out.println("\n Region-wise Sales:\n");
            System.out.println("\tNorth = " + north);
            System.out.println("\tSouth = " + south);
            System.out.println("\tEast  = " + east);
            System.out.println("\tWest  = " + west);

            System.out.println("\n Month-wise Sales:\n");
            System.out.println("\tJune = " + june);
            System.out.println("\tJuly = " + july);
            System.out.println("\tAug  = " + august);

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
