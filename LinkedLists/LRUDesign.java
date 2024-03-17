package LinkedLists;//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way
/*class LNode {
    LNode(int key, int data) {
        this.key = key;
        this.data = data;
        next = null;
    }
    int data;
    int key;
    LNode next;
}

class LRUCache
{
    Map<Integer, LNode> cMap;
    int cap;
    LNode head = null, tail = null;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.cap = cap;
        this.cMap = new HashMap<>(cap);
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        // your code here
        if(this.cMap == null) return -1;
        if(this.cMap.containsKey(key)){
            if(tail.key != key){
                LNode temp = this.cMap.get(key);
                int res = temp.data;
                this.set(key, temp.data);
                return res;
            }
            return this.cMap.get(key).data;
        }
        else return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        LNode node = new LNode(key, value);
        if(this.head == null){
            this.head = node;
        }else{
            this.tail.next = node;
        }

        if(this.cMap.containsKey(key)){
            if(tail.key != key) {
                LNode dlNode = cMap.get(key);
                dlNode.data = dlNode.next.data;
                dlNode.key = dlNode.next.key;
                if(dlNode.next.next == null){
                    tail = dlNode;
                }
                int nextKey = dlNode.next.key;
                dlNode.next = dlNode.next.next;
                cMap.put(nextKey, dlNode);
            }else{
                this.tail.next = null;
                this.tail.data = value;
                return;
            }
        }

        if(this.cMap.size() >= cap){
            if(this.cMap.containsKey(key)){
                if(tail.key != key) {
                    this.cMap.remove(key);
                }
            }else {
                this.cMap.remove(head.key);
                this.head = this.head.next;
            }
        }

        this.tail = node;
        this.cMap.put(key, node);
    }
}*/


class LNode {
    LNode(int key, int data) {
        this.key = key;
        this.data = data;
        next = null;
        prev = null;
    }
    int key;
    int data;
    LNode prev;
    LNode next;
}

class LRUCache
{
    Map<Integer, LNode> cMap;
    int cap;
    LNode head = null, tail = null;
    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        this.cap = cap;
        this.cMap = new HashMap<>(cap);
    }

    //Function to return value corresponding to the key.
    public int get(int key)
    {
        // your code here
        if(this.cMap == null) return -1;
        if(this.cMap.containsKey(key)){
            if(cMap.get(key) == tail)
                return this.cMap.get(key).data;
            else if(cMap.get(key) == head){
                int val = cMap.get(key).data;
                head = removeLeastRecentUsedItem(head.key, head, cMap);
                tail = addItemInCache(key, new LNode(key, val), tail, cMap);
                return tail.data;
            } else {
                int val = cMap.get(key).data;
                removeExistingKeyOrUpdateIfLast(key, cMap.get(key), new LNode(1,0),  cMap);
                tail = addItemInCache(key, new LNode(key, val), tail, cMap);
                return tail.data;
            }
        }
        else return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        LNode node = new LNode(key, value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            cMap.put(key, node);
            return;
        }
        if(!this.cMap.containsKey(key)){
            if(cMap.size() >= this.cap) {
                if(head == tail){
                   cMap.remove(head.key);
                   head = node;
                   tail = node;
                   cMap.put(key, node);
                   return;
                }else
                    head = removeLeastRecentUsedItem(head.key, head, cMap);
            }
            tail = addItemInCache(key, node, tail, cMap);
        } else {
            boolean removed = removeExistingKeyOrUpdateIfLast(key, cMap.get(key), node, cMap);
            if(removed)
                tail = addItemInCache(key, node, tail, cMap);
        }
    }

    LNode removeLeastRecentUsedItem(int key, LNode head, Map<Integer, LNode> cMap) {
        LNode temp = head.next;
        head.next = null;
        temp.prev = null;
        head = temp;
        cMap.remove(key);
        return head;
    }

    LNode addItemInCache(int key, LNode node, LNode tail, Map<Integer, LNode> cMap) {
        tail.next = node;
        node.prev = tail;
        tail = node;
        cMap.put(key, node);
        return tail;
    }

    boolean removeExistingKeyOrUpdateIfLast(int key, LNode dlNode, LNode newNode, Map<Integer, LNode> cMap) {
        if(dlNode.next == null) {
            dlNode.data = newNode.data;
            return false;
        }else if(dlNode.prev == null ){
            head = removeLeastRecentUsedItem(dlNode.key, dlNode, cMap);
            return true;
        } else {
            dlNode.prev.next = dlNode.next;
            dlNode.next.prev = dlNode.prev;
            cMap.remove(key);
            return true;
        }
    }
}
