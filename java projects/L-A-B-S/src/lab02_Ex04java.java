import java.util.Scanner;

public class lab02_Ex04java {

public static void main (String [] args) {

    int num, OriginalNum, ReversedNum = 0;

    Scanner Scan = new Scanner(System.in);

    System.out.print("\nEnter a number (to check whether a number is palindrome or not): ");

    num = Scan.nextInt();
    OriginalNum = (int)num;

    if ( num == 0 ) {
        System.out.println("\n0 is a palindrome.");
        return;

    } else {
        while (num > 0) {
            int digit = num % 10;
            ReversedNum = (ReversedNum * 10) + digit;
            num /= 10;
        }
    }
    System.out.println();

    if (OriginalNum == ReversedNum) {
        System.out.println(OriginalNum + " is a palindrome.");
    } else {
        System.out.println(OriginalNum + " is not a palindrome.");
    }



}

}
