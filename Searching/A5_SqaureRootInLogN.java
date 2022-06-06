package Searching;

import java.util.Scanner;

public class A5_SqaureRootInLogN {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            A5_SqaureRootInLogNSolution obj = new A5_SqaureRootInLogNSolution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
        sc.close();
    }
}// } Driver Code Ends

/*
 * You are required to complete
 * this function
 */

// Function to find square root
// x: element to find square root
class A5_SqaureRootInLogNSolution {
    long floorSqrt(long x) {
        // Your code here
        long l = 1, h = x, res = -1;
        while (l <= h) {
            long m = l + (h - l) / 2;
            long msq = m * m;
            if (msq == x) {
                return m;
            }
            if (x < msq) {
                h = m - 1;
            } else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }
}
