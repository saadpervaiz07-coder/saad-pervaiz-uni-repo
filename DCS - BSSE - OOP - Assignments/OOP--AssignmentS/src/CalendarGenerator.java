
import java.util.Calendar;
import java.util.Scanner;

public class CalendarGenerator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        
        if (month < 1 || month > 12) {
            System.out.println("Invalid month! Please enter a value between 1 and 12.");
            return;
        }
        
        printCalendar(year, month);
        
        scanner.close();
    }
    
    public static void printCalendar(int year, int month) {
        Calendar cal = Calendar.getInstance();
        
        cal.set(year, month - 1, 1);
        
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        String[] monthNames = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        
        System.out.println("\nCalendar for the month of " + monthNames[month - 1] + ", " + year);
        System.out.println("Su  Mo  Tu  We  Th  Fr  Sa");
        
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d  ", day);
            
            if ((day + firstDayOfWeek - 1) % 7 == 0) {
                System.out.println();
            }
        }
        
        System.out.println();
    }
}