
import java.util.Scanner;
import java.util.Calendar;
import java.util.Locale;

public class GeneralCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter year: ");
        int year = input.nextInt();
        System.out.print("Enter month (1 to 12): ");
        int month = input.nextInt();
        input.close();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month! Please enter a value between 1 and 12.");
            return;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1); // Month is 0-based in Java

        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
        System.out.println("\n\tCalendar for the month of " + monthName + ", " + year );
        System.out.println("\n\t------------------------------------");

        System.out.println("\t| Su | Mo | Tu | We | Th | Fr | Sa | \n\t------------------------------------");

        int firstDay = cal.get(Calendar.DAY_OF_WEEK);  // Sunday=1 ... Saturday=7
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.print("\t");

        int currentDay = 1;
        for (int i = 1; i < firstDay; i++) {
            System.out.print("|  _ ");
        }

        for (int i = firstDay; i <= 7; i++) {
            System.out.printf("| %2d ", currentDay++);
        }
        System.out.println("|");

        System.out.print("\t");

        while (currentDay <= daysInMonth) {
            for (int i = 1; i <= 7; i++) {
                if (currentDay <= daysInMonth)
                    System.out.printf("| %2d ", currentDay++);
                else
                    System.out.print("|  _ ");

            }
            System.out.println("|");
            System.out.print("\t");
        }

        System.out.println("------------------------------------");
    }
}
