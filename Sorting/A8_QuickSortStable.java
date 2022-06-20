package Sorting;

public class A8_QuickSortStable {
	static int partition(int a[], int start, int high)
	{
		// Creating temporary
		int temp[] = new int[(high - start) + 1];

		// Choosing a pivot
		int pivot = a[high];
		int index = 0;
	
		// smaller number
		for (int i = start; i <= high; ++i) {
			if (a[i] < pivot)
			{
				temp[index++] = a[i];
			}
		}
	
		// pivot position
		int position = index;
	
		// Placing the pivot to its original position
		temp[index++] = pivot;
	
		for (int i = start; i <= high; ++i)
		{
			if (a[i] > pivot)
			{
				temp[index++] = a[i];
			}
		}

		// Change the original array
		for (int i = start; i <= high; ++i) {
			a[i] = temp[i - start];
		}
	
		// return the position of the pivot
		return position;
	}

	static void quicksort(int numbers[], int start, int end)
	{
		if (start < end) {
			int point = partition(numbers, start, end);

			quicksort(numbers, start, point - 1);
			quicksort(numbers, point + 1, end);
		}
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
		quicksort(numbers, 0, numbers.length - 1);
	
		print(numbers);
	}
}

