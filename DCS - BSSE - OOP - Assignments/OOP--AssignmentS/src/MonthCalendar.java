import java.util.Scanner;
import java.util.Calendar;

public class MonthCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input from user
        System.out.print("\nEnter year: ");
        int year = input.nextInt();
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        // Set up Calendar instance
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1); // months are 0-based in Java

        // Month and year header
        String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.ENGLISH);
        System.out.println("\nCalendar for the month of " + monthName + ", " + year + "\n");

        // Print week headers
        System.out.println("| Su | Mo | Tu | We | Th | Fr | Sa |");

        // Determine first day and number of days
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);  // Sunday = 1, Monday = 2, etc.
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Print leading spaces for days before the 1st
        int day = 1;
        for (int i = 1; i < firstDay; i++) {
            System.out.print("|  _ ");
        }

        // Print days of the month
        for (int i = firstDay; i <= 7; i++) {
            System.out.printf("| %2d ", day++);
        }
        System.out.println("|");

        // Print remaining weeks
        while (day <= daysInMonth) {
            for (int i = 1; i <= 7; i++) {
                if (day <= daysInMonth)
                    System.out.printf("| %2d ", day++);
                else
                    System.out.print("|  _ ");
            }
            System.out.println("|");
        }
        System.out.println("");
        input.close();
    }
}
