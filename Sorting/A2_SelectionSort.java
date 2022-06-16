package Sorting;

import java.util.*;

class SelectionSort {
    int select(int arr[], int i) {
        // code here such that selectionSort() sorts arr[]
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min])
                min = j;
        }
        return min;
    }

    void selectionSort(int arr[], int n) {
        // code here
        int min, temp;
        for (int i = 0; i < n; i++) {
            min = select(arr, i);
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}

public class A2_SelectionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            SelectionSort obj = new SelectionSort();
            obj.selectionSort(arr, n);

            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            t--;
        }
        sc.close();

    }
}
// } Driver Code Ends
