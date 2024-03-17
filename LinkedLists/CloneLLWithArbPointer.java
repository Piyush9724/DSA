package LinkedLists;
import java.util.*;

class NodeArb {
    int data;
    NodeArb next, arb;

    NodeArb(int d) {
        data = d;
        next = arb = null; 
    }
}

class CloneLLWithArbPointer {
    
    public static NodeArb addToTheLast(NodeArb head, NodeArb node) {
        if (head == null) {
            head = node;
            return head;
        } else {
            NodeArb temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(NodeArb head, NodeArb res) {

        NodeArb temp1 = head;
        NodeArb temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;
            
        HashMap<NodeArb,NodeArb> a = new HashMap<NodeArb, NodeArb>();
        
        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
            
            if(temp1==temp2)
                return false;
            
            if (temp1.data != temp2.data) return false;
            
            
            
            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
              else if(temp1.arb== null && temp2.arb !=null)
                return false;
            if(!a.containsKey(temp1)){
                a.put(temp1,temp2);   
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
            
        }
        
        if(a.size()!=len1)
            return false;
        
        temp1 = head;
        temp2 = res;
        while (temp1 != null) {
           
            if (temp1.arb != null && temp2.arb != null) {
                if (a.get(temp1.arb) != temp2.arb) return false;
            } 
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            NodeArb head= null,head2 = null;
            int n = sc.nextInt();
            int q = sc.nextInt();

            int a1 = sc.nextInt();
            head = addToTheLast(head,new NodeArb(a1));
            head2 = addToTheLast(head2,new NodeArb(a1));
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                head = addToTheLast(head, new NodeArb(a));
                head2 = addToTheLast(head2,new NodeArb(a));
            }

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                NodeArb tempA = head;
                NodeArb temp2A = head2;
                int count = -1;

                while (tempA != null) {
                    count++;
                    if (count == a - 1) break;
                    tempA = tempA.next;
                    temp2A = temp2A.next;
                }
                NodeArb tempB = head;
                NodeArb temp2B = head2;
                count = -1;

                while (tempB != null) {
                    count++;
                    if (count == b - 1) break;
                    tempB = tempB.next;
                    temp2B = temp2B.next;
                }

                // when both a is greater than N
                if (a <= n){
                    tempA.arb = tempB;
                    temp2A.arb = temp2B;
                }
            }

            Clone g = new Clone();
            NodeArb res = g.copyList(head);

            if (validation(head, res) == true && validation(head2, res))
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}

class Clone {
    //Function to clone a linked list with next and random pointer.
    //Method 1 Using O(n) extra space using HashMap
   /* NodeArb copyList(NodeArb head) {
        // your code here
        if(head == null) return head;
        NodeArb headCopy = new NodeArb(head.data);
        if(head.next == null && head.arb != null) {
            headCopy.arb = headCopy;
            return headCopy;
        }
        if(head.next == null && head.arb == null) return headCopy;
        
        NodeArb curr = head;
        Map<NodeArb, NodeArb> linkMap = new HashMap<>();
        while(curr != null){
            linkMap.put(curr, new NodeArb(curr.data));
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            linkMap.get(curr).next = linkMap.get(curr.next);
            linkMap.get(curr).arb = linkMap.get(curr.arb);
            curr = curr.next;
        }
        
        return linkMap.get(head);
    }*/
    
    
    //Method 2
    NodeArb copyList(NodeArb head) {
        if(head == null) return head;
        NodeArb headCopy = new NodeArb(head.data);
        if(head.next == null && head.arb != null) {
            headCopy.arb = headCopy;
            return headCopy;
        }
        if(head.next == null && head.arb == null) return headCopy;
        
        NodeArb curr = head;
        while(curr != null) {
            NodeArb clone = new NodeArb(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }
        curr = head;
        while(curr != null) {
                if(curr.arb != null)
                    curr.next.arb = curr.arb.next;
                else
                    curr.next.arb = null;
                curr = curr.next.next;
        }
        
        curr = head;
        NodeArb cloneHead = null, cloneCurr = null, temp = null;
        while (curr != null) {
            temp = curr.next;
            if(cloneHead == null) cloneHead = temp;
            curr.next = temp.next;
            curr = curr.next;
            if(cloneCurr == null) cloneCurr = temp;
            else {
                cloneCurr.next = temp;
                cloneCurr = cloneCurr.next;
            }
        }
        return cloneHead;
    }
}

