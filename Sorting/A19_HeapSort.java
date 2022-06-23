package Sorting;

// { Driver Code Starts
import java.util.*;

public class A19_HeapSort {

    void printArray(int arr[], int n) {
        // int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        A19_HeapSort hs = new A19_HeapSort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            Heap_Sort ob = new Heap_Sort();
            ob.heapSort(arr, n);
            hs.printArray(arr, n);
            T--;
        }
        sc.close();
    }

}

// } Driver Code Ends

class Heap_Sort {
    // Function to build a Heap from array.
    void buildHeap(int arr[], int n) {

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }
    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        buildHeap(arr, n);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
}
