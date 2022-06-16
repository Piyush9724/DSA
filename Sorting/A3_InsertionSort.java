package Sorting;

import java.util.*;

class InsertionSort {
    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        // code here
        int j, key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

public class A3_InsertionSort {

    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            new InsertionSort().insertionSort(a, n);
            printArray(a, n);

            t--;
        }
        sc.close();

    }
}// } Driver Code Ends
