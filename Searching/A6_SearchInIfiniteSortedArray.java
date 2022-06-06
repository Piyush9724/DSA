package Searching;

import java.io.IOException;
import java.util.Scanner;

public class A6_SearchInIfiniteSortedArray {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            long key = sc.nextInt();

            System.out.println(findInInfiniteSortedArray(arr, n, key));
            T--;
        }
        sc.close();
    }

    public static long findInInfiniteSortedArray(long arr[], int n, long key) {
        int l = 0, h = 1;
        if (key == arr[h]) {
            return h;
        }
        if (key > arr[h]) {
            l = h;
            h *= 2;
        } else {
            while (l <= h) {
                int m = (l + h) / 2;
                if (arr[m] == key)
                    return m;
                if (key < arr[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return -1;
        }
        return -1;
    }
}
