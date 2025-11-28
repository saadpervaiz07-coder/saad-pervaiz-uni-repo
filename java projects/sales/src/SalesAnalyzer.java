

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SalesAnalyzer {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\intel\\Desktop\\java projects\\sales\\EVE01Sales.txt";
        String outputFile = "SalesSummary.txt";

        double grandTotal = 0.0;
        Map<String, Double> empTotals = new HashMap<>();     // Rep ID -> total
        Map<String, Double> productTotals = new HashMap<>(); // Product -> total
        Map<String, Double> regionTotals = new HashMap<>();  // Region -> total
        Map<String, Double> monthTotals = new HashMap<>();   // MonthName -> total

        // initialize months (so unknown months won't break ordering)
        String[] monthsOrder = {"January","February","March","April","May","June",
                                "July","August","September","October","November","December"};
        for (String m : monthsOrder) monthTotals.put(m, 0.0);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // skip header

                // Expecting tab-delimited: Date\tRegion\tRep ID\tProduct\tQty\tUnit Price
                String[] parts = line.split("\t");
                if (parts.length < 6) {
                    // skip malformed lines
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String dateStr = parts[0].trim();
                String region = parts[1].trim();
                String repId = parts[2].trim();
                String product = parts[3].trim();
                String qtyStr = parts[4].trim();
                String priceStr = parts[5].trim();

                int qty;
                double unitPrice;
                try {
                    qty = Integer.parseInt(qtyStr);
                    unitPrice = Double.parseDouble(priceStr);
                } catch (NumberFormatException nfe) {
                    System.out.println("Skipping line with number error: " + line);
                    continue;
                }

                double sale = qty * unitPrice;
                grandTotal += sale;

                // Employee totals
                empTotals.put(repId, empTotals.getOrDefault(repId, 0.0) + sale);

                // Product totals
                productTotals.put(product, productTotals.getOrDefault(product, 0.0) + sale);

                // Region totals
                regionTotals.put(region, regionTotals.getOrDefault(region, 0.0) + sale);

                // Month totals (try to extract month name from date string)
                String monthName = extractMonthName(dateStr);
                if (monthName == null) monthName = "Unknown";
                monthTotals.put(monthName, monthTotals.getOrDefault(monthName, 0.0) + sale);
            }

            // Prepare output (sorted for readability)
            StringBuilder summary = new StringBuilder();
            summary.append("========================================\n");
            summary.append("            SALES ANALYSIS\n");
            summary.append("========================================\n\n");
            summary.append(String.format("Grand Total Sales Amount : %.2f%n%n", grandTotal));

            summary.append("----- Employee-wise Sales (Rep ID) -----\n");
            for (Map.Entry<String, Double> e : sortByValueDesc(empTotals)) {
                summary.append(String.format("%-8s : %.2f%n", e.getKey(), e.getValue()));
            }
            summary.append("\n");

            summary.append("----- Product-wise Sales -----\n");
            for (Map.Entry<String, Double> e : sortByValueDesc(productTotals)) {
                summary.append(String.format("%-10s : %.2f%n", e.getKey(), e.getValue()));
            }
            summary.append("\n");

            summary.append("----- Region-wise Sales -----\n");
            for (Map.Entry<String, Double> e : sortByValueDesc(regionTotals)) {
                summary.append(String.format("%-10s : %.2f%n", e.getKey(), e.getValue()));
            }
            summary.append("\n");

            summary.append("----- Month-wise Sales (Jan → Dec) -----\n");
            // keep chronological order Jan..Dec, then Unknown if any
            for (String m : monthsOrder) {
                double amt = monthTotals.getOrDefault(m, 0.0);
                summary.append(String.format("%-10s : %.2f%n", m, amt));
            }
            // print any Unknown months if present
            if (monthTotals.containsKey("Unknown") && monthTotals.get("Unknown") > 0.0) {
                summary.append(String.format("%-10s : %.2f%n", "Unknown", monthTotals.get("Unknown")));
            }

            // Print to console
            System.out.println(summary.toString());

            // Also write to file
            try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile))) {
                pw.print(summary.toString());
            }
            System.out.println("✅ Summary written to " + outputFile);

        } catch (IOException ioe) {
            System.err.println("I/O Error: " + ioe.getMessage());
        }
    }

    /**
     * Try to extract month name (full, capitalized) from date string by searching
     * for known month abbreviations or full names.
     * Returns e.g. "June" or null if not found.
     */
    private static String extractMonthName(String dateStr) {
        if (dateStr == null) return null;
        String s = dateStr.toLowerCase();

        // mapping of month tokens (short and full) to full month name
        Map<String, String> monthMap = new LinkedHashMap<>();
        monthMap.put("jan", "January"); monthMap.put("january", "January");
        monthMap.put("feb", "February"); monthMap.put("february", "February");
        monthMap.put("mar", "March"); monthMap.put("march", "March");
        monthMap.put("apr", "April"); monthMap.put("april", "April");
        monthMap.put("may", "May");
        monthMap.put("jun", "June"); monthMap.put("june", "June");
        monthMap.put("jul", "July"); monthMap.put("july", "July");
        monthMap.put("aug", "August"); monthMap.put("august", "August");
        monthMap.put("sep", "September"); monthMap.put("sept", "September"); monthMap.put("september", "September");
        monthMap.put("oct", "October"); monthMap.put("october", "October");
        monthMap.put("nov", "November"); monthMap.put("november", "November");
        monthMap.put("dec", "December"); monthMap.put("december", "December");

        for (Map.Entry<String,String> e : monthMap.entrySet()) {
            if (s.contains(e.getKey())) return e.getValue();
        }
        return null;
    }

    /** Utility to sort a map by value descending and return a list of entries */
    private static <K> List<Map.Entry<K, Double>> sortByValueDesc(Map<K, Double> map) {
        return map.entrySet()
                  .stream()
                  .sorted((a,b) -> Double.compare(b.getValue(), a.getValue()))
                  .collect(Collectors.toList());
    }
}
