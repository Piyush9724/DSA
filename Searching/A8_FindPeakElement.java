package Searching;

import java.util.*;

public class A8_FindPeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                tmp[i] = a[i];
            }

            int f = 0;
            int A = (new PeakElementSolution()).peakElement(tmp, n);

            if (A < 0 && A >= n)
                System.out.println(0);
            else {
                if (n == 1 && A == 0)
                    f = 1;
                else if (A == 0 && a[0] >= a[1])
                    f = 1;
                else if (A == n - 1 && a[n - 1] >= a[n - 2])
                    f = 1;
                else if (A >= 0 && A < n && a[A] >= a[A + 1] && a[A] >= a[A - 1])
                    f = 1;
                else
                    f = 0;
                System.out.println(f);
            }
        }
        sc.close();
    }
}// } Driver Code Ends

/* Complete the function below */

class PeakElementSolution {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr, int n) {
        // add code here.
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid])
                    && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            }
            if (mid > 0 && arr[mid - 1] >= arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}