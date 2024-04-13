package LinkedLists;
import java.util.*;

class LL09LL_Palindrome
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			LL09LL_Palindrome llist = new LL09LL_Palindrome();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        if(head == null) return false;
        if(head.next  == null ) return true;
        boolean result = true;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node curr = head, revCurr;
        if(fast.next != null) {
            if(slow.next == fast && fast.next == null)
                return head.data == fast.data;
        }
        revCurr = reverseList(slow.next);
        slow.next = revCurr;
        while(revCurr != null ) {
            if(curr.data != revCurr.data) result = false;
            revCurr = revCurr.next;
            curr = curr.next;
        }
        slow.next = reverseList(slow.next);
        return result;
    }
    
    Node reverseList(Node head)
    {
        // code here
        if(head == null || head.next == null) return head;
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
        return first;
    }
}

