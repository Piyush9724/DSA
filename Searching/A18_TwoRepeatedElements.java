package Searching;

import java.io.*;

public class A18_TwoRepeatedElements  {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            TwoRepeatedElementsSolution obj = new TwoRepeatedElementsSolution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}// } Driver Code Ends


//User function template for JAVA

class TwoRepeatedElementsSolution
{
    //Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int N)
    {
        // Your code here
        int[] ans = new int[2];
        int j = 0;
        for(int i = 0; i< N+2;i++){
            int absVal = Math.abs(arr[i]);
            if( arr[absVal] > 0){
                arr[absVal] =  - arr[absVal];
            }else{
                ans[j] = absVal;
                j++;
            }
        }
        return ans;
    }
    
}