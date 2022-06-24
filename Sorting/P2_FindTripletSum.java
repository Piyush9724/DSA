package Sorting;

import java.util.*;

class FindTriplets {
    // arr[]: input array
    // n: size of the array
    // Function to find triplets with zero sum.
    public boolean findTriplets(int arr[], int n) {
        // add code here.
        if (n == 1) {
            if (arr[0] == 0)
                return true;
            else
                return false;
        }
        if (n == 2) {
            if (arr[0] + arr[1] == 0)
                return true;
            else
                return false;
        }
        if (n == 3) {
            if (arr[0] + arr[1] + arr[2] == 0)
                return true;
            else
                return false;
        }
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            int l = i, r = n - 1;
            int curSum = arr[i - 1];
            while (l < r) {
                curSum = arr[i - 1];
                curSum += arr[l] + arr[r];
                if (curSum == 0)
                    return true;
                else if (curSum < 0)
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
}

public class P2_FindTripletSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            FindTriplets g = new FindTriplets();
            if (g.findTriplets(a, n))
                System.out.println("1");
            else
                System.out.println("0");

        }
        sc.close();
    }
}

/* Complete the function below */
