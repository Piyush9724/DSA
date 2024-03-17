package LinkedLists;//{ Driver Code Starts
import java.util.*;

public class LL03InsertAtExactMiddle {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();   
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++){
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            int key = sc.nextInt();
            
            //display(head);
            InsertAtExactMiddleSolution obj = new InsertAtExactMiddleSolution();
            obj.insertInMid(head, key);
            display(head);
            System.out.println();
        }
    }
    
    public static void display(Node head){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/
class InsertAtExactMiddleSolution {
    
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        Node node = new Node(data);
        //Simple Approach
        /*long length = 0, count = 0;
        if(head == null) return node;
        Node curr = head;
        while(curr != null) {
            ++length;
            curr = curr.next;
        }
        //System.out.println(length);
        curr = head;
        long mid = length % 2 == 0 ? length/2 - 1 : length /2;
        while(mid != 0) {
            --mid;
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return head;*/
        
        //Two Pointer Rabbit and Tortoise approach
        Node fast = head.next;
        Node slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        node.next = slow.next;
        slow.next = node;
        return head;
    }
}