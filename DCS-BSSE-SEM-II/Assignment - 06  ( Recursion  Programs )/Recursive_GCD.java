
import java.util.Scanner;

public class Recursive_GCD 
{
    // GCD --> Greatest Commom Divisor
    public static int gcd(int a, int b) 
    {
        if (b == 0) return a;
        return gcd(b, (a % b));
    }

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("\n Enter the 1st number: ");
        int num1 = scan.nextInt();

        System.out.print(" Enter the 2nd number: ");
        int num2 = scan.nextInt();

        int result = gcd(num1, num2);
        System.out.println("\n GCD of '" + num1 + "' and '" + num2 + "' is: " + result);

        scan.close();
    }
    
}

