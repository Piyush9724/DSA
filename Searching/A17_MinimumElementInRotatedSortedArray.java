package Searching;

import java.io.*;


public class A17_MinimumElementInRotatedSortedArray {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(MinimumElementInRotatedSortedArraySolution.minNumber(arr, 0, n - 1));
        }
    }

}// } Driver Code Ends

class MinimumElementInRotatedSortedArraySolution {
    // Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high) {
        // Your code here
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid] < arr[mid - 1])
                    &&
                    (mid == arr.length - 1 || arr[mid] < arr[mid + 1])) {
                return arr[mid];
            } else if (arr[mid] > arr[arr.length - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[0];
    }
}



/*
7
70 3 20 22 33 48 51


5
6 11 24 37 42
 */
