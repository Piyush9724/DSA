package LinkedLists;

import java.util.*;

class DLLNode
{
	int data;
	DLLNode next;
	DLLNode prev;
	DLLNode(int d)
	{
		data = d;
		next = prev = null;
	}
}
class LL05DeleteNodeinDLL
{
	DLLNode head;
	DLLNode tail;
	
	void addToTheLast(DLLNode node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(DLLNode head)
	{	DLLNode temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			LL05DeleteNodeinDLL list = new LL05DeleteNodeinDLL();
			
			int a1 = sc.nextInt();
			DLLNode head = new DLLNode(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new DLLNode(a));
			}
			a1 = sc.nextInt();
			LL05DeleteNodeinDLLSolution g = new LL05DeleteNodeinDLLSolution();
			//System.out.println(list.temp.data);
			DLLNode ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}



class LL05DeleteNodeinDLLSolution
{
    // function returns the head of the linkedlist
	DLLNode deleteNode(DLLNode head,int x)
    {
	// Your code here	
		DLLNode curr = head;
	    if(head == null) return head;
	    while(x != 1 && curr != null) {
	        --x;
	        curr = curr.next;
	    }
	    if(curr.next == null) {
			curr.prev.next = null;
			return head;
		}
		if(curr.prev == null) {
			curr.next.prev = null;
			return curr.next;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		return head;
    }
}
