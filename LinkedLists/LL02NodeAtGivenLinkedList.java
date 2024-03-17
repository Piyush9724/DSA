package LinkedLists;

import java.lang.*;
import java.util.*;

class nthNode
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            LL02NodeAtGivenLinkedList gfg = new LL02NodeAtGivenLinkedList();
            System.out.println(gfg.getNth(head, k));
        }
    }

    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class LL02NodeAtGivenLinkedList
{

    public static int getNth(Node node, int ind)
    {
        //Your code here
        System.out.println(node.data + " "+ ind);
        if (node == null) return 0;
        if (ind == 1) return node.data;
        int currIndex = 1;
        while (node.next != null && currIndex != ind) {
            node = node.next;
            ++currIndex;
        }
        return node.data;
    }
}
