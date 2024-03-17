package LinkedLists;
import java.util.*;
import java.io.*;

class LL07ReverseLL {
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            LL07ReverseLLSolution ob = new LL07ReverseLLSolution();
            head = ob.reverseList(head);
            printList(head); 
            t--;
        }
    } 
} 


class LL07ReverseLLSolution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        // code here
        //Iterative Solution
       /* if(head == null || head.next == null) return head;
        Node first = head;
        Node second = head.next;
        Node temp;
        while( second != null) {
            temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        head.next = null;
        return first;*/
        
        //Recursive Solution
        if(head == null || head.next == null) {
            return head;
        }
        Node revHead = reverseList(head.next);
        Node revTail = head.next;
        revTail.next = head;
        head.next = null;
        return revHead;
    }
}
