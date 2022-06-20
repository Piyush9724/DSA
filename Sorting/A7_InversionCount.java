package Sorting;

import java.util.*;

public class A7_InversionCount {
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(InversionCount.inversionCount(arr, n));
            
        }
        sc.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class InversionCount
{
    
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Attempt 1 O(n^2)
        /*
        long count = 0;
        for(int i=0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if( arr[i] >arr[j])
                    count++;
            }
        }
        return count;
        */
        return mergeSort(arr, 0, arr.length-1);
    }
    
    
    static long mergeSort(long arr[], int l, int r) {
        // code here
        long count = 0;
        if (l < r) {
        // Same as (l+r)/2, but avoids overflow for
        // large l and r
            int m = l + (r - l) / 2;
            count += mergeSort(arr, l, m);
            count += mergeSort(arr, m + 1, r);
            count += merge(arr, l, m, r);
        }
        return count;
    }

    static long merge(long arr[], int l, int m, int r) {
        // Your code here
        /* create temp arrays */
        long count  = 0;
        long[] L = new long[m - l + 1];
        long[] R = new long[r - m];

        /* Copy data to temp arrays L[] and R[] */
        for (int i = 0; i < L.length; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < R.length; j++) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays back into arr[l..r]*/
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                count += (m - l + 1)-i; // size of left array - i
                j++;
            }
            k++;
        }
        /* Copy the remaining elements of L[], if there are any */
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of R[], if there are any */
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return count;
    }
}