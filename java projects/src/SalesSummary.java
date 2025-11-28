
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SalesSummary {

public static void main(String[] args) {

String fileName = "EVE01Sales.txt";
double totalSales = 0;
double e011 = 0, e012 = 0, e013 = 0, e014 = 0;
double prodA = 0, prodB = 0, prodC = 0, prodD = 0;
double north = 0, south = 0, east = 0, west = 0;
double june = 0, july = 0, august = 0;
SimpleDateFormat f1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
SimpleDateFormat f2 = new SimpleDateFormat("MMM-dd-yy", Locale.ENGLISH);
SimpleDateFormat fm = new SimpleDateFormat("MMMM", Locale.ENGLISH);
try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
String line = br.readLine();
line = br.readLine();
while (line != null) {
String[] d = line.split("\\t");
if (d.length >= 6) {
try {
String dateStr = d[0].trim();
String region = d[1].trim();
String rep = d[2].trim();
String product = d[3].trim();
int qty = Integer.parseInt(d[4].trim());
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
else if (region.equalsIgnoreCase("East")) east += sale;
else if (region.equalsIgnoreCase("West")) west += sale;
try {
Date date;
if (dateStr.matches("\\d{1,2}-[A-Za-z]{3}-\\d{4}"))
date = f1.parse(dateStr);
else
date = f2.parse(dateStr);
String month = fm.format(date);
if (month.equalsIgnoreCase("June")) june += sale;
else if (month.equalsIgnoreCase("July")) july += sale;
else if (month.equalsIgnoreCase("August")) august += sale;
} catch (ParseException e) {}
} catch (NumberFormatException e) {}
}
line = br.readLine();
}
System.out.println("Total Sales Amount = " + totalSales);
System.out.println("\nEmployee-wise Sales:");
System.out.println("E011 = " + e011);
System.out.println("E012 = " + e012);
System.out.println("E013 = " + e013);
System.out.println("E014 = " + e014);
System.out.println("\nProduct-wise Sales:");
System.out.println("Product A = " + prodA);
System.out.println("Product B = " + prodB);
System.out.println("Product C = " + prodC);
System.out.println("Product D = " + prodD);
System.out.println("\nRegion-wise Sales:");
System.out.println("North = " + north);
System.out.println("South = " + south);
System.out.println("East = " + east);
System.out.println("West = " + west);
System.out.println("\nMonth-wise Sales:");
System.out.println("June = " + june);
System.out.println("July = " + july);
System.out.println("August = " + august);
} catch (IOException e) {
System.out.println("Error: " + e.getMessage());
}
}
}