// ✅ Import statements (must always be on top)
import java.io.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

// 🔹 Class representing an E-Book's information
class EBookInfo {
    // Attributes (Encapsulation)
    private String title;
    private String author;
    private int year;
    private double price;
    private String genre;

    // Constructor
    public EBookInfo(String title, String author, int year, double price, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.genre = genre;
    }

    // Method to display info in console
    public void displayInfo() {
        System.out.println("\n--- E-Book Information ---");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Year  : " + year);
        System.out.println("Genre : " + genre);
        System.out.println("Price : $" + price);
    }

    // Getters (for PDF export)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getGenre() { return genre; }
}

// 🔹 Main Class (Implementer)
public class BookApp {
    public static void main(String[] args) {
        // Creating object of EBookInfo class
        EBookInfo book = new EBookInfo(
                "Introduction to Java Programming",
                "James Gosling",
                2020,
                39.99,
                "Programming"
        );

        // Display book info in terminal
        book.displayInfo();

        // Export book info as PDF
        try {
            // Create a new PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("EBookInfo.pdf"));
            document.open();

            // Add content to PDF
            document.add(new Paragraph("E-Book Information",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK)));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Title  : " + book.getTitle()));
            document.add(new Paragraph("Author : " + book.getAuthor()));
            document.add(new Paragraph("Year   : " + book.getYear()));
            document.add(new Paragraph("Genre  : " + book.getGenre()));
            document.add(new Paragraph("Price  : $" + book.getPrice()));

            document.close(); // Close document
            System.out.println("\n✅ Book information exported to PDF successfully!");

        } catch (Exception e) {
            System.out.println("\n❌ Error creating PDF: " + e.getMessage());
        }
    }
}
