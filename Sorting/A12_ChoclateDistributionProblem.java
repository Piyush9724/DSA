package Sorting;

import java.util.*;
public class A12_ChoclateDistributionProblem {
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            ChoclateDistributionProblemSolution ob = new ChoclateDistributionProblemSolution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        sc.close();
        
    }
}// } Driver Code Ends


//User function Template for Java

class ChoclateDistributionProblemSolution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int i=0,j=4;
        long minDiff = Integer.MAX_VALUE;
        while(j<n){
            minDiff = Long.min(minDiff, a.get(j)-a.get(i));
            i++;
            j++;
        }
        return minDiff;
    }
}
