
import java.util.Arrays;

public class Recursive_Max_Array 
{

    public static int maxVal(int[] arr, int index, int currentMax) 
    {
        if (index == arr.length)     { return currentMax; }
        if (arr[index] > currentMax) { currentMax = arr[index]; }
        return maxVal(arr, index + 1, currentMax);
    }

    public static void main(String[] args) 
    {
        int[] arr = { 25 , 67 , 23 , 59 , 17 , 33 , 37 , 13 , 29 , 69 };
        System.out.println("\n Finding the max value in array: " + Arrays.toString(arr));

        int max = maxVal(arr, 0, arr[0]);
        System.out.println("\n The max value in array is:  " + max);
    }
    
}


