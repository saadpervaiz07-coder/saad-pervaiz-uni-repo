
import java.util.*;

public class Bisection_Solvr
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("\n Enter an equation (like, x^2 + 3x - 5):  ");
        String eq = in.nextLine().replaceAll("\\s+", "");

        System.out.print(" Enter the first  value: ");
        double a = in.nextDouble();

        System.out.print(" Enter the second value: ");
        double b = in.nextDouble();

        double tol = 0.001, c = 0;
        double faInitial = solve(eq, a);
        double fbInitial = solve(eq, b);

        if((faInitial * fbInitial) > 0)
        {
            System.out.println("\n Error: f(a) and f(b) must have opposite signs.");
            System.out.println(" Bisection Method cannot start.");
            return;
        }

        while(true)
        {
            c = (a + b)/2;
            double fa = solve(eq, a);
            double fc = solve(eq, c);

            if(Math.abs(fc) < tol)
            {
                System.out.println("\n Root found near: " + c);
                System.out.println(" f(x) = " + fc);
                break;
            }

            if((fa * fc) < 0) { b = c; }
            else { a = c; }
        }

        in.close();
        System.out.println();
    }

    static double solve(String eq, double x)
    {
        double sum = 0;
        for(String p : eq.split("(?=[+-])"))
        {
            double val;
            if(p.contains("x^"))
            {
                String coeff = p.substring(0, p.indexOf("x"));
                double c = (coeff.equals("") || coeff.equals("+")) ? 1 : coeff.equals("-") ? -1 : Double.parseDouble(coeff);
                int pow = Integer.parseInt(p.substring(p.indexOf("^") + 1));
                val = ( c * Math.pow(x, pow) );
            }
            else if(p.contains("x"))
            {
                String coeff = p.substring(0, p.indexOf("x"));
                double c = (coeff.equals("") || coeff.equals("+")) ? 1 : coeff.equals("-") ? -1 : Double.parseDouble(coeff);
                val = (c * x);
            }
            else
            {
                val = Double.parseDouble(p);
            }

            sum = (sum + val);
        }

        return sum;
    }
}


/*

// OUTPUT:

 Enter an equation (like, x^2 + 3x - 5):  x^2 - 4
 Enter the first  value: 1
 Enter the second value: 3

 Root found near: 2.0
 f(x) = 0.0


Process finished with exit code 0


// OUTPUT:

 Enter an equation (like, x^2 + 3x - 5):  x^2 - 4
 Enter the first  value: -2
 Enter the second value: 3

 Root found near: 2.000244140625
 f(x) = 9.766221046447754E-4


Process finished with exit code 0

*/

