
import java.util.Scanner;

public class RecursiveFibonacciNumber 
{

    public static int fn(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return ( fn(n - 1) + fn(n - 2) );
    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n Enter the value of 'n': ");
        int n = scan.nextInt();
        System.out.println("\n Fibonacci number at nth-term: " + fn(n) );
        scan.close();
    }
}
