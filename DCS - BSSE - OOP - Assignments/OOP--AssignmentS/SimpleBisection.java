import java.util.*;

public class SimpleBisection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your equation (like x^2+3x-5):");
        String eq = in.nextLine().replaceAll("\\s+", ""); // remove spaces

        System.out.print("Enter first value: ");
        double a = in.nextDouble();

        System.out.print("Enter second value: ");
        double b = in.nextDouble();

        double tol = 0.001;
        double c = 0;

        while (true) {
            c = (a + b) / 2;
            double fa = solve(eq, a);
            double fb = solve(eq, b);
            double fc = solve(eq, c);

            if (Math.abs(fc) < tol) {
                System.out.println("\nRoot found near: " + c);
                System.out.println("f(x) = " + fc);
                break;
            }

            if (fa * fc < 0)
                b = c;
            else
                a = c;
        }

        in.close();
    }

    static double solve(String eq, double x) {
        double sum = 0;
        String[] parts = eq.split("(?=[+-])");

        for (String p : parts) {
            p = p.trim();
            double val;

            if (p.contains("x^")) {
                String coeff = p.substring(0, p.indexOf("x"));
                double c = coeff.equals("") || coeff.equals("+") ? 1 :
                           coeff.equals("-") ? -1 : Double.parseDouble(coeff);
                int pow = Integer.parseInt(p.substring(p.indexOf("^") + 1));
                val = c * Math.pow(x, pow);
            }
            else if (p.contains("x")) {
                String coeff = p.substring(0, p.indexOf("x"));
                double c = coeff.equals("") || coeff.equals("+") ? 1 :
                           coeff.equals("-") ? -1 : Double.parseDouble(coeff);
                val = c * x;
            }
            else {
                val = Double.parseDouble(p);
            }
            sum += val;
        }
        return sum;
    }
}
