package Arrays;

import java.util.HashMap;

import java.util.Map;


public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {8,3,4,8,8};
       // System.out.println(majorityElement(a, a.length));
       int res = findMajorityElementIndex(a, a.length);
       int majoritElementIndex = checkMajority(a, a.length, res);
       if( majoritElementIndex == -1) System.out.println(-1);
       else System.out.println(a[majoritElementIndex]);
    }

    //Approach 2    MOORE'S VOTING ALGORITHM
    //TC O(n) SC O(1)
    static int findMajorityElementIndex(int a[], int size){
        int res = 0, count  = 1;
        for( int i = 1; i < size; i++ ) {
            if( a[res] ==  a[i]) 
                count++;
            else    
                count--;
            if(count  == 0) {
                res = i;
                count  = 1;
            }
        }
        return res;
    }

    static int checkMajority(int a[], int size, int res) {
        int count  = 0;
        for(int i=0;i< size;i++) {
            if( a[res] == a[i]) count++;
        }
        if(count <= (size/2)) return -1;
        else return res; 
    }
    //---------------------------------------------End of Approach 2 -------------------//

    //Approach 1
    //TC O(n)  SC O(N)   
    static int majorityElement(int a[], int size)
    {
        // your code here
        Map<Integer,Integer> elements = new HashMap<>();
        for(int i=0;i<size;i++){
            elements.put(a[i], elements.getOrDefault(a[i], 0)+1);
        }

        for (int x : elements.keySet()) {
            if(elements.get(x) > (size/2) ) return x;
        }
        return -1;
    }
}
