package Searching;

import java.io.*;


public class A4_CountNoOf0inReverseSortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new CountNoOf0inReverseSortedArraySolution().countZeroes(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class CountNoOf0inReverseSortedArraySolution {
    int countZeroes(int[] arr, int n) {
        // code here
        return n-higher(arr,n);
    }
    
    int higher(int arr[], int n){
        int l = 0;
        int r = n;
        while(l<r){
            int m = l + (r-l) /2;
            if( 0 >= arr[m]) r = m;
            else l = m+1; 
        }
        return l;
    }

}
