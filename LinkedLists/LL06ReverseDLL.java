package LinkedLists;


import java.lang.*;
import java.io.*;

class LL06ReverseDLL
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            DLLNode head = null, tail = null;
            for(int i = 0; i < n; i++)
            {
                int data = Integer.parseInt(str[i]);
                if (head == null) 
                {
                    head = new DLLNode(data);
                    tail = head;
                }
                else
                {
                    tail.next = new DLLNode(data);
                    tail.next.prev=tail;
                    tail = tail.next;
                }
            }
            head=reverseDLL(head);
            if(verify(head))
    	    displayList(head);
    	    else
    	    System.out.print("Your pointers are not correctly connected");
            System.out.println();
                
        }
    }
    
    
    
    public static void displayList(DLLNode head)
    {
        //Head to Tail
        while(head.next != null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.print(head.data);

    }
    public static DLLNode reverseDLL(DLLNode  head)
    {
        //Your code here
        if(head == null) return head;
        DLLNode temp = null;
        DLLNode curr = head;
        while ( curr != null ){
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            head = curr;
            curr = curr.prev;
        }
        return head;
    }


    public static boolean verify(DLLNode head)
    {
        int fl=0;
        int bl=0;

        DLLNode temp=head;

        while(temp.next!=null)
        {
            temp=temp.next;
            fl++;
        }

        while(temp.prev!=null)
        {
            temp=temp.prev;
            bl++;
        }

        return fl==bl;
    }
}