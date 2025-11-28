import java.util.Scanner;

public class lab02_Ex03java {
    public static void main (String [] args) {

        Scanner Scan = new Scanner(System.in) ;

        System.out.print("\nenter your amount (in dollars): ");

        double amount = Scan.nextDouble();

        int Dollar = (int)Math.floor(amount) ;

        int cents =  (int)( (amount - Dollar)*100 ) ;

        int quarter = cents/25;

        int dimes = (cents % 25)/10;

        int nickel = ((cents % 25) % 10)/5;

        int penny = (((cents % 25) % 10) % 5)/1;

        System.out.println("\nDollar         : " + Dollar);
        System.out.println("Cents          : " + cents);
        System.out.println("Quarter        : " + quarter);
        System.out.println("Dimes          : " + dimes);
        System.out.println("Nickels        : " + nickel);
        System.out.println("Remaining-Penny: " + penny);

    }
}