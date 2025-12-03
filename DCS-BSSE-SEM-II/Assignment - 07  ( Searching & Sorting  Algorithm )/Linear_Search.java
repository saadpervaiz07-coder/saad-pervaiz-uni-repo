
import java.util.*;

public class Linear_Search
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] array = { 0 , 2 , 5 , 9 , 8 , 2 , -3 };

        System.out.println("\n Array: " + Arrays.toString(array));

        int al = array.length, occur = 0;

        System.out.print("\n Enter your Target: ");
        int target = sc.nextInt();

        for(int i=0 ; i<al ; i++)
        {
            if(array[i] ==  target)
            {
                System.out.print("\n Target found at index '" + i + "' ");
                occur++;
            }
        }
        if (occur>0)
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
