package Hashing;

import java.util.*;

class SubarrayWithSum0Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // Your code here
        Set<Integer> hs = new HashSet<>();
        int sum = 0;
        hs.add(sum);
        for (int i : arr) {
            sum += i;
            if (hs.contains(sum))
                return true;
            hs.add(sum);
        }
        return false;
    }
}

public class A5_SubarrayWithSum0 {
    public static void main(String[] args) {
        // code
        // code

        // taking input using class Scanner
        Scanner scan = new Scanner(System.in);

        // taking total number of testcases
        int t = scan.nextInt();
        while (t > 0) {
            // taking total count of elements
            int n = scan.nextInt();

            // Declaring and Initializing an array of size n
            int arr[] = new int[n];

            // adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            t--;

            // calling the method findSum
            // and print "YES" or "NO" based on the result
            System.out.println( SubarrayWithSum0Solution.findsum(arr, n) == true ? "Yes" : "No");
        }
        scan.close();
    }

}// } Driver Code Ends

/*
1
5
4 2 -3 1 6
 */