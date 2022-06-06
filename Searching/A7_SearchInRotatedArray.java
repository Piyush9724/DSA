package Searching;

import java.util.*;

public class A7_SearchInRotatedArray{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new A7_SearchInRotatedArraySolution().search(A, 0, n - 1, key));
        }
        sc.close();
    }
}// } Driver Code Ends


//User function Template for Java
//5 6 7 8 9 10 1 2 3
// 437 / 440 Test Case Passed, on the right path, Keep Going Dude!.
// Learn the Optimized way.
//After thinking for 10 min and going through the code I Optimized the approach and
// 440/440 TC Passed.
class A7_SearchInRotatedArraySolution
{
    int search(int A[], int l, int h, int key)
    {
        // Complete this function
        if(h < l){
            return -1;
        }
        int m  = l + (h-l) / 2;
        if(key == A[m]) return m;
        if(A[l] > A[h]){
            int res;
            res  = search(A, l, m, key);
            if( res != -1) return res;
            res = search(A, m+1, h, key);
            return res;

        }else{
            //Optimised Block
            if(key<A[h])
                return binarysearch(A, l, h, key);
            else 
                return -1;
        }
    }

    int binarysearch(int arr[], int l, int r, int key ) {
        // code hereh
        while(l<=r){
            int m = (l+r)/2;
            if( arr[m] == key) return m;
            if(key < arr[m]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }
}


// 1 2 3 4 5 6 7

// 1 2 3 5 6 7 8 9 10

// 