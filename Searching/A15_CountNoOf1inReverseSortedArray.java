package Searching;

import java.util.*;


public class A15_CountNoOf1inReverseSortedArray {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0){
		   
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i = 0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		   
		    System.out.println(CountNoOf1inReverseSortedArraySolution.countOnes(arr, n));
		    
		}
        sc.close();
		
	}
}// } Driver Code Ends


//User function Template for Java

class CountNoOf1inReverseSortedArraySolution{
    // Function to count number of ones in the binary array
    // N: size of array
    // arr[]: input array
    public static int countOnes(int arr[], int N){
        
        // Your code here
        //return higher(arr,N);
        return count(arr,0, N-1);
        
    }
    
    static int higher(int arr[], int N){
        int l = 0, r = N;
        while(l<r){
            int m = l + (r - l) /2 ;
            if( 1 <= arr[m]){
                 l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
    
    
    static int count(int arr[], int low, int high)
    {
        if (high >= low)
        {
            // get the middle index
            int mid = low + (high - low) / 2;
 
            // check if the element at middle index is last
            // 1
            if ((mid == high || arr[mid + 1] == 0)
                && (arr[mid] == 1))
                return mid + 1;
 
            // If element is not last 1, recur for right
            // side
            if (arr[mid] == 1)
                return count(arr, (mid + 1), high);
 
            // else recur for left side
            return count(arr, low, (mid - 1));
        }
        return 0;
    }
}

