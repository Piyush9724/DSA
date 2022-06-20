package Sorting;

public class A10_QuickSortUnstableHoaresP {
    // This function takes first element as pivot, and
    // places all the elements smaller than the pivot on the
    // left side and all the elements greater than the pivot
    // on the right side. It returns the index of the last
    // element on the smaller side
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
 
        while (true)
        {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);
 
            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);
 
            // If two pointers met.
            if (i >= j)
                return j;
           
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
             
        }
    }
 
    // The main function that
    // implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
           
            // pi is partitioning index,
            // arr[p] is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi);
            quickSort(arr, pi + 1, high);
        }
    }


   static void swap(int arr[], int i, int j) {
    int temp  = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
   }

   // Function to print the array
	static void print(int numbers[])
	{
		for (int a : numbers)
		{
			System.out.print(a + " ");
		}
	}

	public static void main(String[] args)
	{
		int numbers[] = { 3, 2, 1, 78, 9798, 97 };
	
		// rearrange using naive partition
		quickSort(numbers, 0, numbers.length - 1);
	
		print(numbers);
	}
}
