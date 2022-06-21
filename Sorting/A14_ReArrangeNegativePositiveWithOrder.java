package Sorting;

import java.io.*;

public class A14_ReArrangeNegativePositiveWithOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int) (n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }

            ReArrangeNegativePositiveWithOrder.segregateElements(a, n);

            for (int i = 0; i < n; i++)
                System.out.print(a[i] + " ");

            System.out.println();
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class ReArrangeNegativePositiveWithOrder {

    public static void segregateElements(int a[], int n) {
        // Your code goes here
        RearrangePosNeg(a, 0, n - 1);
    }

    // Function to Rearrange positive and negative
    // numbers in a array
    static void RearrangePosNeg(int arr[], int l, int r) {
        if (l < r) {
            // Same as (l + r)/2, but avoids overflow for
            // large l and h
            int m = l + (r - l) / 2;

            // Sort first and second halves
            RearrangePosNeg(arr, l, m);
            RearrangePosNeg(arr, m + 1, r);
            //mergeWithExtraSpace(arr, l, m, r);
            mergeInPlace(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void mergeWithExtraSpace(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays back into arr[l..r] */
        // Initial index of first subarray
        i = 0;

        // Initial index of second subarray
        j = 0;

        // Initial index of merged subarray
        k = l;

        // Note the order of appearance of elements should
        // be maintained - we copy elements of left subarray
        // first followed by that of right subarray

        // copy negative elements of left subarray
        while (i < n1 && L[i] < 0)
            arr[k++] = L[i++];

        // copy negative elements of right subarray
        while (j < n2 && R[j] < 0)
            arr[k++] = R[j++];

        // copy positive elements of left subarray
        while (i < n1)
            arr[k++] = L[i++];

        // copy positive elements of right subarray
        while (j < n2)
            arr[k++] = R[j++];
    }

    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    /*
     * Function to reverse an array. An array can be
     * reversed in O(n) time and O(1) space.
     */
    static void reverse(int arr[], int l, int r) {
        if (l < r) {
            arr = swap(arr, l, r);
            reverse(arr, ++l, --r);
        }
    }

    /*
     * The problem with this approach is we are using auxiliary array for merging
     * but we’re not allowed to use any data structure to solve this problem. We can
     * do merging in-place without using any data-structure. The idea is taken from
     * here.
     * Let Ln and Lp denotes the negative part and positive part of left sub-array
     * respectively. Similarly, Rn and Rp denote the negative and positive part of
     * right sub-array respectively.
     * 
     * Below are the steps to convert [Ln Lp Rn Rp] to [Ln Rn Lp Rp] without using
     * extra space.
     * 
     * 1. Reverse Lp and Rn. We get [Lp] -> [Lp'] and [Rn] -> [Rn']
     * [Ln Lp Rn Rp] -> [Ln Lp’ Rn’ Rp]
     * 
     * 2. Reverse [Lp’ Rn’]. We get [Rn Lp].
     * [Ln Lp’ Rn’ Rp] -> [Ln Rn Lp Rp]
     */

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void mergeInPlace(int arr[], int l, int m, int r) {
        int i = l; // Initial index of 1st subarray
        int j = m + 1; // Initial index of IInd

        while (i <= m && arr[i] < 0)
            i++;

        // arr[i..m] is positive

        while (j <= r && arr[j] < 0)
            j++;

        // arr[j..r] is positive

        // reverse positive part of
        // left sub-array (arr[i..m])
        reverse(arr, i, m);

        // reverse negative part of
        // right sub-array (arr[m+1..j-1])
        reverse(arr, m + 1, j - 1);

        // reverse arr[i..j-1]
        reverse(arr, i, j - 1);
    }

}


/*
1
9
-12 11 -13 -5 6 -7 5 -3 -6
 */