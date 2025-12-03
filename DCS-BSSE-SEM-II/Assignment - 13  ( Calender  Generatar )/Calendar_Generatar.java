
import java.util.*;

public class Calendar_Generatar
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("\n Enter the year: ");
        int year = in.nextInt();

        System.out.print(" Enter the month (1 to 12): ");
        int month = in.nextInt();

        if (month < 1 || month > 12)
        {
            System.out.println("\n Invalid month! Enter between 1 and 12.");
            return;
        }

        Calendar c = Calendar.getInstance();
        c.set(year, (month - 1), 1);

        String monthName = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        System.out.println("\n\n\tCalendar for the month of " + monthName + ", " + year);
        System.out.println("\n\n\t  Su   Mo   Tu   We   Th   Fr   Sa    \n");

        int firstDay = c.get(Calendar.DAY_OF_WEEK);
        int maxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.print("\t");

        for (int i = 1; i < firstDay; i++)
            System.out.print("     ");

        for (int day = 1; day <= maxDays; day++)
        {
            System.out.printf("  %2d ", day);

            if ((firstDay + day - 1) % 7 == 0)
                System.out.print("\n\t");
        }

        System.out.println("\n\n");
    }
}
