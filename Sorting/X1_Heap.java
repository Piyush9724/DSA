package Sorting;

// { Driver Code Starts
import java.util.*;

public class X1_Heap {

    void printArray(int arr[], int n) {
        // int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        X1_Heap hs = new X1_Heap();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Heap_Sor_Des ob = new Heap_Sor_Des();
            ob.heapSort(arr, n,k);
           hs.printArray(arr, n);
            T--;
        }
        sc.close();
    }

}

// } Driver Code Ends

class Heap_Sor_Des {
    // Function to build a Heap from array.
    void buildHeap(int arr[], int n,String mode) {

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, mode);
    }
    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i,String mode) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if("Min".equals(mode)){
            if (l < n && arr[l] < arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r] < arr[largest])
                largest = r;
        }else{
            if (l < n && arr[l] > arr[largest])
            largest = l;

            // If right child is larger than largest so far
            if (r < n && arr[r] > arr[largest])
                largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            if("Min".equals(mode)){
                heapify(arr, n, largest,"Min");
            }else{
                heapify(arr, n, largest,"Max");
            }
        }
    }
    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n,int k) {
        List<Integer> res = new ArrayList<>();
        buildHeap(arr,k+1,"Max");
        for (int i = k; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0,"Max");
        }
        
        res.add(arr[0]);
        for(int i = k+1;i<n;i++){
            arr[0] = arr[i];
            heapify(arr,k+1,0,"Min");
            res.add(arr[0]);
        }

        int c = k;
        for(int i=0;i<k;i++){
            arr[0] = arr[c];
            heapify(arr, c, 0, "Min");
            res.add(arr[0]);
            c--;
        }
       
    
        for (Integer integer : res) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }
}


/*
1
7 3
6 5 3 2 8 10 9
 */