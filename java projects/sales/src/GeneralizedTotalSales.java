import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GeneralizedTotalSales {
    public static void main(String[] args) {
        // Apni file ka path yahan likho 👇
        String fileName = "EVE01Sales (2).txt";

        double totalSales = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true; // first line header hoti hai

            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                // Header line skip
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split columns (tab delimited)
                String[] columns = line.split("\t");

                // Defensive check: file ke andar har line ke 6 columns hone chahiye
                if (columns.length < 6) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    // Qty and Unit-Price columns (index 4 and 5)
                    double qty = Double.parseDouble(columns[4].trim());
                    double price = Double.parseDouble(columns[5].trim());

                    // Sale Amount for that record
                    double sale = qty * price;

                    // Add to total
                    totalSales += sale;

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number line: " + line);
                }
            }

            // Final total output
            System.out.println("====================================");
            System.out.printf("Total of All Sale Amount = %.2f %n", totalSales);
            System.out.println("====================================");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
