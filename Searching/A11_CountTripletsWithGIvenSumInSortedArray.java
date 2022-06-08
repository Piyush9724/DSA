package Searching;

import java.io.*;
import java.util.Arrays;


class CountTripletsWithGIvenSumInSortedArray{
    
    int Countpair(int a[], int n, int sum){
        int curSum,count=0;
        for(int  i = 0; i< n-2;i++){
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                curSum =  a[i] + a[l] + a[r];
                if(curSum == sum) {
                    count++;
                    l++;
                    r--;
                }else if(curSum < sum) l++;
                else r--;
            }
        }
        return count;
    }
  
    int CountpairWrong(int a[], int n, int sum)
    {
        // Complete the function
        Arrays.sort(a);
        int l = 0, r = n-1, m, curSum,count =0;
        while(l  < r ) {
            curSum = a[l] + a[r];
            if( curSum < sum ){
                m = l+1;
                while( m < r ){
                    if( curSum + a[m] == sum) {
                        count ++;
                        break;
                    }
                    m++;
                }
            }
            else if( curSum >= sum) {
                m = r-1;
                while( m > l ){
                    if( curSum + a[m] == sum) {
                        count ++;
                        break;
                    }
                    m--;
                }
            }
            l++;
            r--;
        }
        return count;
    }



  
    
}


// { Driver Code Starts.

// Driver class
public class A11_CountTripletsWithGIvenSumInSortedArray {
    
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
		    
		    CountTripletsWithGIvenSumInSortedArray obj = new CountTripletsWithGIvenSumInSortedArray();
		   
		    int res = obj.Countpair(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


  // } Driver Code Ends