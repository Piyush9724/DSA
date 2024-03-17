package LinkedLists;

import java.util.*;
import java.io.*;

public class LL01LinkedListsInsertion {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Node head = null;
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                int indicator = sc.nextInt();

                LL01LinkedListsInsertionSolution ob = new LL01LinkedListsInsertionSolution();
                if (indicator == 0)
                    head = ob.insertAtBeginning(head, value);
                else
                    head = ob.insertAtEnd(head, value);
            }
            printList(head);
            t--;
        }
    }
}

class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class LL01LinkedListsInsertionSolution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        // code here
        Node node = new Node(x);
        if (head != null) {
            node.next = head;
        }
        return node;
    }

    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        // code here
        Node node = new Node(x);
        if(head == null){
            return node;
        } else {
            Node curr = head;
            while( curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        return head;
    }
}
