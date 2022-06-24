package Sorting;

import java.io.*;
import java.util.*;

class FindNumberOfTrianglesSolution {
    // Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (arr[i] + arr[l] > arr[r]) {
                    count += r - l;
                    l++;
                    r = n - 1;
                } else
                    r--;
            }
        }
        return count;
    }
}

public class P4_FindNumberOfTriangles {
    public static void main(String args[]) throws IOException {
        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t > 0) {
            // taking elements count
            int n = sc.nextInt();

            // creating an array of length n
            int arr[] = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            // calling the method findNumberOfTriangles()
            // of class Solutions and printing the results
            System.out.println(FindNumberOfTrianglesSolution.findNumberOfTriangles(arr, n));
            t--;
        }
        sc.close();
    }
}
// } Driver Code Ends

// User function Template for Java
