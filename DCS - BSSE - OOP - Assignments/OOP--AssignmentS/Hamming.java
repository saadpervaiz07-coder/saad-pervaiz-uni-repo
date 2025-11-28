public class Hamming
{
    public static void main(String args[])
    {
        int msg[] = {0,0,1,0,1,0,0,0,0,1,1,0,1,1};
        int n = msg.length;

        int r = 0;
        while(Math.pow(2, r) < (n + r + 1))
        {
            r++;
        }

        for(int h = 1; h <= r; h++)
        {
            int p = (int)Math.pow(2, h - 1);
            int step = p;
            int s = 0;

            for(int i = p; i < n; i += (2 * step))
            {
                for(int j = i; j < i + step && j < n; j++)
                {
                    s = s + msg[j];
                }
            }

            int bit = s % 2;
            System.out.println("h" + h + " = " + bit);
        }
    }
}



public class first
{
    public static void main(String args[])
    {
        String input = "1100001110011";
        int message[] = {0,0,1,0,1,0,0,0,0,1,1,0,1,1};

        // test for case no.01 h1
        int sum = 0;
        for(int i = 1; i < message.length; i = i + 2)
        {
            sum = sum + message[i];
        }
        System.out.println("sum for h1 = " + sum);

        // test for case no.02 h2
        int sum2 = 0;
        for(int i = 2; i < message.length; i = i + 4)
        {
            if(i < message.length)
                sum2 = sum2 + message[i];
            if(i + 1 < message.length)
                sum2 = sum2 + message[i + 1];
        }
        System.out.println("sum for h2 = " + sum2);

        // test for case no.03 h3
        int sum3 = 0;
        for(int i = 4; i < message.length; i = i + 8)
        {
            for(int j = i; j < i + 4 && j < message.length; j++)
            {
                sum3 = sum3 + message[j];
            }
        }
        System.out.println("sum for h3 = " + sum3);

        // test for case no.04 h4
        int sum4 = 0;
        for(int i = 8; i < message.length; i = i + 16)
        {
            for(int j = i; j < i + 8 && j < message.length; j++)
            {
                sum4 = sum4 + message[j];
            }
        }
        System.out.println("sum for h4 = " + sum4);

        // test for case no.05 h5
        int sum5 = 0;
        for(int i = 16; i < message.length; i = i + 32)
        {
            for(int j = i; j < i + 16 && j < message.length; j++)
            {
                sum5 = sum5 + message[j];
            }
        }
        System.out.println("sum for h5 = " + sum5);
    }
}
