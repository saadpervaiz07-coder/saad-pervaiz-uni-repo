
import java.util.*;

public class Hamming_Code
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String bits;

        while (true)
        {
            System.out.print("\n\n Enter the bit string (0/1):  ");
            bits = input.nextLine().trim();

            if (bits.matches("[01]+")) break;
            System.out.println( "\n Invalid Inputt! Use only 0's and 1's.\n");        }

        ArrayList<Integer> encoded = encode(bits);
        System.out.print("\n\n ENCODED STRING: \n ->  ");
        print(encoded);

        Random rnd = new Random();
        int errorPos = ( rnd.nextInt(encoded.size()) + 1 );

        ArrayList<Integer> withError = flip(encoded, errorPos);
        System.out.print("\n AFTER ERROR: (bit " + errorPos + " flipped) \n ->  ");
        print(withError);

        int foundError = findError(withError);
        System.out.println("\n ERROR DETECTED POSITION: " + foundError);
        System.out.println();

    }

    static void print(ArrayList<Integer> arr)
    {
        for (int x : arr) { System.out.print(x + " "); }
        System.out.println();
    }

    static ArrayList<Integer> flip(ArrayList<Integer> arr, int pos)
    {
        ArrayList<Integer> out = new ArrayList<>(arr);
        out.set((pos - 1) , (out.get(pos - 1) ^ 1));
        return out;
    }

    static boolean pow2(int x)
    {
        return ( (x > 0) && (x & (x - 1)) == 0 );
    }

    static ArrayList<Integer> encode(String bits)
    {
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 1, j = 0; j < bits.length(); i++)
        {
            if (pow2(i)) { data.add(0); }
            else { data.add(bits.charAt(j++) - '0'); }
        }

        for (int i = 0; i < data.size(); i++)
        {
            int pos = (i + 1);
            if (pow2(pos))
            {
                int p = calcParity(data, pos);
                data.set(i, p);
            }

        }
        return data;

    }

    static int calcParity(ArrayList<Integer> data, int pos)
    {
        int parity = 0;

        for (int i = (pos - 1); i < data.size(); i += (2 * pos))
        {
            for (int j = i ; (j < (i + pos)) && (j < data.size()) ; j++)  { parity ^= data.get(j); }
        }

        return parity;

    }

    static int findError(ArrayList<Integer> data)
    {
        int error = 0;

        for (int i = 0; i < data.size(); i++)
        {
            int pos = (i + 1);

            if (pow2(pos))
            {
                int p = calcParity(data, pos);
                if (p == 1) { error += pos; }
            }

        }

        return error;

    }

}



