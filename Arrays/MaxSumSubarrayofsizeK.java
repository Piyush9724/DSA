package Arrays;

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class MaxSumSubarrayofsizeK
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            MaxSumSubarrayofsizeKSolution ob = new MaxSumSubarrayofsizeKSolution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class MaxSumSubarrayofsizeKSolution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
       int i=0,j=0;
       int maxSum = Integer.MIN_VALUE;
       int curSum = 0;
       while(j<N) {
           curSum+=Arr.get(j);
           if(j-i+1 == K){
               maxSum = Integer.max(maxSum, curSum);
               curSum -= Arr.get(i);
               i++;
           }
           j++;
       }
       return maxSum;
    }
}

