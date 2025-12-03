
import java.util.*;

public class Bubble_Sort
{

    public static void swap(int[] Array, int i, int j)
    {
        int temp = Array[i];
        Array[i] = Array[j];
        Array[j] = temp;
    }

    public static void main(String[] args)
    {
        System.out.print("\n Bubble  Sorting   ");
        System.out.print("\n ``````````````` \n");

        int[] array = { 0 , 2 , 5 , 9 , 8 , 2 , -3 };
        int al = array.length;

        System.out.println("\n Array before Sorting: " + Arrays.toString(array));

        for(int i = 0; i < (al - 1); i++)
        {
            for(int j = 0; j < (al - 1 - i); j++)
            {
                if(array[j] > array[(j + 1)])
                {
                    swap(array, j, (j + 1));
                }

            }

        }

        System.out.println("\n Array after  Sorting: " + Arrays.toString(array));
        System.out.println();

    }

}


