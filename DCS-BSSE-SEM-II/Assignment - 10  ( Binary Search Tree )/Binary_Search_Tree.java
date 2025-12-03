
import java.io.*;
import java.util.*;

public class Binary_Search_Tree
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int[][] bst = loadBST("bst.csv");

        while (true)
        {
            System.out.print("\n\n==== BINARY SEARCH TREE MENU ====\n");
            System.out.print("\n 1. Print leaf nodes");
            System.out.print("\n 2. Search number");
            System.out.print("\n 3. Show parent & children");
            System.out.print("\n 4. In-order traversal");
            System.out.print("\n 5. Quit");
            System.out.print("\n\n Choose your option from (1 to 5): ");

            int op = sc.nextInt();
            switch (op)
            {
                case 1:
                    printLeaves(bst);
                    break;

                case 2:
                    System.out.print("\n Enter a number: ");
                    int t = sc.nextInt();
                    int idx = search(bst, t, 0);
                    System.out.println( (idx != -1) ? " Found at index: " + idx : " Not found!");
                    break;

                case 3:
                    System.out.print("\n Enter a number: ");
                    t = sc.nextInt();
                    printParentChild(bst, t);
                    break;

                case 4:
                    System.out.print("\n In-Order:  ");
                    inOrder(bst, 0);
                    System.out.println();
                    break;

                case 5:
                    saveBST(bst, "bst.csv");
                    System.out.println("\n Saved & Exited. \n");
                    return;

                default:
                    System.out.println("\n Invalid Choice!");
            }

        }

    }

    static int[][] loadBST(String file) throws Exception
    {
        Scanner sc = new Scanner(new File(file));
        List<int[]> list = new ArrayList<>();

        while (sc.hasNextLine())
        {
            String[] p = sc.nextLine().split(",");
            list.add(new int[]{Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2])});
        }

        sc.close();
        return list.toArray(new int[0][0]);

    }

    static void saveBST(int[][] bst, String file) throws Exception
    {
        FileWriter fw = new FileWriter(file);
        for (int[] node : bst)
        {
            fw.write(node[0] + "," + node[1] + "," + node[2] + "\n");
        }
        fw.close();

    }

    static void printLeaves(int[][] bst)
    {
        System.out.print("\n Leaves:  ");
        for (int[] node : bst)
        {
            if ( (node[0] == -1) && (node[2] == -1) ) { System.out.print(node[1] + "  "); }
        }
        System.out.println();

    }

    static int search(int[][] bst, int val, int i)
    {
        if (i == -1) { return -1; }
        if (bst[i][1] == val) { return i; }
        return ( val < bst[i][1] ) ?
                search(bst, val, bst[i][0]) : search(bst, val, bst[i][2]);
    }

    static void printParentChild(int[][] bst, int val)
    {
        int idx = search(bst, val, 0);
        if (idx == -1)
        {
            System.out.println("\n Value not found!");
            return;
        }

        int parent = findParent(bst, val, 0, -1);

        System.out.println( "\n Parent  :  " + ( parent == -1 ? "None (root)" : bst[parent][1] ) );
        System.out.println(   " Children:  " +
                    ( (bst[idx][0] != -1) ? bst[bst[idx][0]][1] : "none" ) + ", " +
                    ( (bst[idx][2] != -1) ? bst[bst[idx][2]][1] : "none" ) );

    }

    static int findParent(int[][] bst, int val, int i, int parent)
    {
        if (i == -1) { return -1; }
        if (bst[i][1] == val) { return parent; }
        return ( val < bst[i][1] ) ?
                findParent(bst, val, bst[i][0], i) : findParent(bst, val, bst[i][2], i);
    }

    static void inOrder(int[][] bst, int i)
    {
        if (i == -1) { return; }
        inOrder(bst, bst[i][0]);
        System.out.print(bst[i][1] + "  ");
        inOrder(bst, bst[i][2]);
    }


}


