
import java.io.*;
import java.nio.file.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

class BookInfo
{
    String title, author, publisher;
    int year;
    double price;

    BookInfo(String t, String a, String p, int y, double pr)
    {
        title = t;
        author = a;
        publisher = p;
        year = y;
        price = pr;
    }

    void displayDetails()
    {
        System.out.println("\n----- BOOK DETAILS -----");
        System.out.println("Title: "      + title     +
                "\nAuthor: "    + author    +
                "\nPublisher: " + publisher +
                "\nYear: "      + year      +
                "\nPrice: $"    + price     +
                "\n------------------------");
    }

}

class EBookInfo extends BookInfo
{
    String file;

    EBookInfo(String t, String a, String p, int y, double pr, String f)
    {
        super(t, a, p, y, pr);
        file = f;
    }

    void displayContent()
    {
        try { Files.lines(Paths.get(file)).forEach(System.out::println); }
        catch (IOException e) { System.out.println("Error reading file!"); }
    }

    void saveAsPDF(String pdf)
    {
        try
        {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(pdf));
            doc.open();
            doc.add(new Paragraph(new String(Files.readAllBytes(Paths.get(file)))));
            doc.close();
            System.out.println("\nPDF saved as: " + pdf);
        }
        catch (Exception e) { System.out.println("Error saving PDF!"); }

    }

    void openInNotepad()
    {
        try { Runtime.getRuntime().exec("notepad.exe " + file); }
        catch (Exception e) { System.out.println("Error opening Notepad!"); }

    }

}

public class EBookMainClass
{
    public static void main(String[] args)
    {
        EBookInfo ebook = new EBookInfo(
                "Introduction to Programming",
                "Paul and Harry Denial",
                "Paul and Harry Denial",
                2000,
                49.99,
                "INTRODUCTION_TO_PROGRAMMING.txt"
        );

        ebook.displayDetails();
        ebook.displayContent();
        ebook.saveAsPDF("INTRODUCTION_TO_PROGRAMMING.pdf");
        ebook.openInNotepad();

    }

}




