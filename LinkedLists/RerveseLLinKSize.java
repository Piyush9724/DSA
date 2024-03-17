package LinkedLists;
import java.io.*;
import java.lang.*;


class RerveseLLinKSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            RerveseLLinKSizeSolution ob = new RerveseLLinKSizeSolution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

class RerveseLLinKSizeSolution
{
   /* public static Node reverse(Node head, int k)
    {
        //Your code here
        if(head == null || head.next == null || k==1) return head;
        head = repeatPart(head, k);
        return head;
    }*/

    public static Node repeatPart(Node head, int k) {
        Node first = head, second = head;
        int i = 1;
        while (i++ != k) {
            if(second == null && second == first) return null;
            if(second.next != null)
                second = second.next;
        }
        i = 1;
        Node temp;
        if(second == null || second.next == null) temp = null;
        else temp = second.next;
        second.next = null;
        head = reverseChunk(first);
        first.next = repeatPart(temp, k);
        return head;
    }
    
    public static Node reverseChunk(Node head){
        if(head == null || head.next == null) {
            return head;
        }
        Node revHead = reverseChunk(head.next);
        Node revTail = head.next;
        revTail.next = head;
        head.next = null;
        return revHead;
    }



    public static Node reverse(Node head, int k) {
        Node first = head;
        Node second = head.next;
        Node temp = null;
        int count = 1;
        while( second != null && count < k) {
            temp = second.next;
            second.next = first;
            first = second;
            second = temp;
            count++;
        }
        head.next = null;
        if(temp != null) {
            Node rest_head = reverse(temp, k);
            head.next = rest_head;
        }
        return first;
    }
}

