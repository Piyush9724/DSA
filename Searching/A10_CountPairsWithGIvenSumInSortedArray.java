package Searching;

import java.io.*;

class CountPairsWithGIvenSumInSortedArraySolution{
    
  
    int Countpair(int a[], int n, int sum)
    {
        // Complete the function
        int l = 0, r = n-1;
        int curSum = 0, count = 0;
        while(l<r){
            curSum = a[l] + a[r];
            if( curSum == sum) {
                count ++;
                l++;
                r--;
            }
            else if(curSum < sum) l++;
            else r--;
        }
        if(count > 0)
            return count;
        else return -1;
    }
  
    
}


// { Driver Code Starts.

// Driver class
public class A10_CountPairsWithGIvenSumInSortedArray {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    CountPairsWithGIvenSumInSortedArraySolution obj = new CountPairsWithGIvenSumInSortedArraySolution();
		   
		    int res = obj.Countpair(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


  // } Driver Code Ends