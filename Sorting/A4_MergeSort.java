package Sorting;

import java.util.*;
class MergeSort {

    /* l is for left index and r is right index of the
   sub-array of arr to be sorted */
    void mergeSort(int arr[], int l, int r) {
        // code here
        if (l < r) {
        // Same as (l+r)/2, but avoids overflow for
        // large l and r
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        // Your code here

        /* create temp arrays */
        int[] L = new int[m - l + 1];
        int[] R = new int[r - m];

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

    }
}

public class A4_MergeSort {
    // method to print the elements of the array
    static void printArray(int arr[]) {
        StringBuffer sb = new StringBuffer("");
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            sb.append(arr[i] + " ");
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking testcases
        int T = sc.nextInt();
        while (T > 0) {
            // taking elements count
            int n = sc.nextInt();

            // creating an array of size n
            int arr[] = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            MergeSort g = new MergeSort();

            // calling the method mergeSort
            g.mergeSort(arr, 0, arr.length - 1);

            // calling the method printArray
            A4_MergeSort.printArray(arr);
            T--;
        }
        sc.close();
    }
}

// } Driver Code Ends


