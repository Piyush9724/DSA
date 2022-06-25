package Sorting;

import java.util.*;

public class P5_CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            System.out.println(CountingSort.countSort(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends

class CountingSort {
    // Function to arrange all letters of a string in lexicographical
    // order using Counting Sort.
    public static String countSort(String array) {
            
        char arr[] = array.toCharArray();
        int n = arr.length;

        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[256];

        // store count of each character
        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; i++)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
            
            
        String string = new String(arr);  
        return string;
    }
}