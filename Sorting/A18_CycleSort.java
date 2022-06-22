package Sorting;
import java.util.*;

class CycleSort{
    // does cycle sort and gives 
    // min number of swaps required to sort an array 
    // in O(n^2) time
    public static int cycleSort(int arr[], int n){
        int countSwap = 0;
        for (int cs = 0; cs<n-1;cs++){
            int item = arr[cs];
            int pos = cs;
            for(int i = cs+1;i<n;i++){
                if(arr[i] < item) pos++;
            }
            //swap item and arr[pos]
            if( item != arr[pos]) countSwap++;
            int temp  = arr[pos];
            arr[pos] = arr[cs];
            arr[cs] = temp;
            item  =  temp;
            //
            while(pos != cs){
                pos = cs;
                for(int i = cs+1;i<n;i++){
                    if(arr[i] < item) pos++;
                }
                //swap item and arr[pos]
                if( item != arr[pos]) countSwap++;
                temp  = arr[pos];
                arr[pos] = arr[cs];
                arr[cs] = temp;
                item  =  temp;
                //
            }
        }
        return countSwap;
    }
}

public class A18_CycleSort {
    
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
			int swaps = CycleSort.cycleSort(arr,n);
			
			//calling printArray() method
			printArray(arr);

            System.out.println("Number of Swaps :: "+ swaps);
			
		t--;	
		}
        sc.close();
	}

}
