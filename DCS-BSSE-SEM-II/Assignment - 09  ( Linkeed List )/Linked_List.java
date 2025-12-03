import java.util.Scanner;

public class Linked_List
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Node.startingIndex = 1;
        Node[] linked_list = { new Node(65, 3), new Node(15, 2), new Node(45, 0), new Node(72, -1) };

        String message = "";
        while (true)
        {
            System.out.println();
            System.out.println(" ACTIONS: ");
            System.out.println(" ```````` ");
            System.out.println("\t 1. Create a new linked list");
            System.out.println("\t 2. Add an element to the list");
            System.out.println("\t 3. Print all elements of the list");
            System.out.println("\n Type 1, 2, 3  ( or )  Type 'quit' to exit.");
            System.out.print(  "\n Now Choose any option: ");

            message = scanner.nextLine().trim();
            if(message.equalsIgnoreCase("quit")) { break; }

            if(message.equals("1"))
            {
                linked_list = new Node[0];
                Node.startingIndex = -1;
                System.out.println("\n New Empty list created.\n");
            }
            else if (message.equals("2"))
            {
                System.out.print("\n Enter the element (number): ");
                String line = scanner.nextLine().trim();
                try
                {
                    float num = Float.parseFloat(line);
                    linked_list = addElement(num, linked_list);
                    System.out.println(" Successfully Added: " + num + "\n");
                }
                catch (NumberFormatException e)
                {
                    System.out.println("\n Invalid number. Try again.\n");
                }

            }
            else if (message.equals("3"))
            {
                printLinkedList(linked_list);
            }
            else
            {
                System.out.println("\n Invalid choice. Try again.\n");
            }

        }

        scanner.close();
        System.out.println("\nProgram Exited Successfully!");
    }

    public static void printLinkedList(Node[] ll)
    {
        int i = Node.startingIndex;
        System.out.print("\n Linked List:  ");
        if (i == -1 || ll.length == 0) {
            System.out.println("( empty )");
            System.out.println();
            return;
        }
        System.out.print("[  ");

        while (i != -1)
        {
            System.out.print(ll[i].data + " ");
             i = ll[i].nextIndex;
            if(i != -1) { System.out.print(" ->  "); }
        }
        System.out.println(" ] \n\n Successfully Printed! \n");

    }

    public static Node[] addElement(float new_num, Node[] linked_list)
    {
        int i = Node.startingIndex;
        int j = Node.startingIndex;

        if (linked_list.length == 0)
        {
            linked_list = addListElement(linked_list, new Node(new_num, -1));
            Node.startingIndex = 0;
        }
        else if (new_num < linked_list[i].data)
        {
            Node.startingIndex = linked_list.length;
            linked_list = addListElement(linked_list, new Node(new_num, i));
        }
        else
        {
            while (i != -1 && linked_list[i].data <= new_num)
            {
                j = i;
                i = linked_list[i].nextIndex;
            }
            linked_list[j].nextIndex = linked_list.length;
            linked_list = addListElement(linked_list, new Node(new_num, i));

        }
        return linked_list;

    }

    public static Node[] addListElement(Node[] ll, Node element)
    {
        Node[] newll = new Node[ll.length + 1];
        for (int k = 0; k < ll.length; k++) newll[k] = ll[k];
        newll[newll.length - 1] = element;
        return newll;
    }

}

class Node
{
    static int startingIndex;
    float data;
    int nextIndex;

    Node(float d, int ni)
    {
        data = d;
        nextIndex = ni;
    }

}
