
import java.util.*;

public class Binary_Search
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] array = { 0 , 2 , 5 , 9 , 8 , 2 , -3 };

        Arrays.sort(array);

        System.out.println("\n Array: " + Arrays.toString(array));

        int al = array.length, occur = 0;

        System.out.print("\n Enter your Target: ");

        int target = sc.nextInt();

        int low = 0, mid = 0, high = (al - 1);

        while ((low <= high) && (occur == 0))
        {
            mid =  low + ((high - low) / 2);

            if(array[mid] ==  target)
            {
                System.out.print("\n Target found at index '" + mid + "' ");
                occur++;

                // Check Leftward, for multiple occurences of target
                int left = (mid - 1);
                while ((left > -1) && (array[left] == target))
                {
                    System.out.print("\n Target also found at index '" + left + "' ");
                    left--; occur++;
                }

                // Check rightward, obviously for multiple occurences of our target
                int right = (mid + 1);
                while ((right < al) && (array[right] == target))
                {
                    System.out.print("\n Target also found at index '" + right + "' ");
                    right++; occur++;
                }
            break;
            }

            else if (array[mid] < target) { low  = (mid + 1); }
            else if (array[mid] > target) { high = (mid - 1); }

        }

        if (occur > 0)
        {
            System.out.println("\n\n Target occur '" + occur + "' time(s). \n");
        }
        else
        {
            System.out.println("\n\n Target not Found in the Array! \n");
        }

        sc.close();
    }
}
