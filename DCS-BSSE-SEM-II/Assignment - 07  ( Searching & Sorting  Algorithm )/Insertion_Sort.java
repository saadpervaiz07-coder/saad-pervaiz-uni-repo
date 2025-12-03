
import java.util.*;

public class Insertion_Sort
{

    public static void swap(int[] Array, int i, int j)
    {
        int temp = Array[i];
        Array[i] = Array[j];
        Array[j] = temp;
    }

    public static void main(String[] args)
    {
        System.out.print("\n Insertion  Sorting   ");
        System.out.print("\n `````````````````` \n");

        int[] array = { 0 , 2 , 5 , 9 , 8 , 2 , -3 };
        int al = array.length;

        System.out.println("\n Array before Sorting: " + Arrays.toString(array));

        for (int i = 1; i < al; i++)
        {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }

        System.out.println("\n Array after  Sorting: " + Arrays.toString(array));
        System.out.println();

    }

}


