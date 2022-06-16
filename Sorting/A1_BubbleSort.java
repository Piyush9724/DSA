package Sorting;
import java.util.*;

class BubbleSort
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]> arr[j+1]){
                    arr[j] += arr[j+1];
                    arr[j+1] =  arr[j] - arr[j+1];
                    arr[j] -= arr[j+1];
                }
            }
        }
    }
}

// { Driver Code Starts.

public class A1_BubbleSort {
    //method to print the Elements of the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		while(t>0)
		{
		    //taking total elements
			int n = sc.nextInt();
			
			//creating a new array of length n
			int arr[] = new int[n];
			
			//inserting elements to the array
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt(); 
			}
			
			
			//calling bubbleSort() method
			BubbleSort.bubbleSort(arr,n);
			
			//calling printArray() method
			printArray(arr);
			
		t--;	
		}
        sc.close();
	}

}  // } Driver Code Ends