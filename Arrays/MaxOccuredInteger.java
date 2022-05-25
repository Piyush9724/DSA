package Arrays;

import java.io.*;
import java.util.*;


public class MaxOccuredInteger {

    	public static void main (String[] args) throws IOException{
    	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //taking size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int L[] = new int[n];
		    int R[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to array L
		    for(int i=0; i<n; i++){
		        L[i]=Integer.parseInt(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    int maxx = Integer.MIN_VALUE;
		    
		    //adding elements to array R
		    for(int i=0; i<n; i++){
		        R[i]=Integer.parseInt(inputLine[i]);
		        if(R[i] > maxx){
		            maxx=R[i];
		        }
		    }
		    
		    MaxOccuredIntegerSolution obj = new MaxOccuredIntegerSolution();
		    
		    //calling maxOccured() function
		    System.out.println(obj.maxOccured(L, R, n, maxx));
		}
	}
	
}
 // } Driver Code Ends
// L[] and R[] are input ranges
// n : size of array
// maxx: maximum element in R[]
// arr[]: declared globally with size equal to 1000000

class MaxOccuredIntegerSolution{
    static int arr[] = new int[1000000];
    //Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int L[], int R[], int n, int maxx){

        for(int i=0;i<n;i++){
            arr[L[i]]++;
            arr[R[i]+1]--;
        }
        
        for(int i=1;i<maxx;i++){
            arr[i] += arr[i-1];
        }
        int maxElIndex = 0;
        for(int i=0;i<maxx;i++){
            if(arr[i+1]>arr[i]){
                maxElIndex = i+1;
            }
        }
        return maxElIndex;
    }    
}

// { Driver Code Starts.

  // } Driver Code Ends