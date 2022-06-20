package Sorting;

public class A9_QuickSortUnstableLomutoP {
    static int lomutoPartition(int arr[], int l, int h) {
        int pivot = arr[h];
        int i= l-1;

        for(int j=l;j<=h;j++){
            if( arr[j] < pivot) {
                i++;
                swap(arr,i, j);
            }
        }
        swap(arr,i+1, h);
        return i+1;
    }

    static void qSort(int arr[], int l, int h){
        if( l < h){
            int p = lomutoPartition(arr, l, h);
            qSort(arr, l, p-1);
            qSort(arr, p+1, h);
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
		qSort(numbers, 0, numbers.length - 1);
	
		print(numbers);
	}
}
