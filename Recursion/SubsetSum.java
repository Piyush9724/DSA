package Recursion;

import java.util.stream.IntStream;

public class SubsetSum {
    public static void main(String[] args) {
       int a[] = {10,20,5,15,13,12};
       int cur[] = {};
       System.out.println(subsetSum(a, cur, 0,25));
       int b[] = {10,20,15};
       System.out.println(subsetSumOptimal(b, 3, 25));
       System.out.println(subsetSumOptimal(a, 6, 25));
    }

    //Optimal Approach using recursion
    public static int subsetSumOptimal(int a[], int n, int sum){
        if( n == 0)
            return sum==0?1:0;
        return subsetSumOptimal(a, n-1, sum) + subsetSumOptimal(a, n-1, sum-a[n-1]); 
    }


    //Maintainin a extra array NOT OPTIMAL  (MY APPROACH)
    public static int subsetSum(int a[], int cur[], int j, int sum){
        if( a.length == j) {
            // System.out.print("{");
            // for(int i=0;i< cur.length;i++) System.out.print(cur[i]+ " ");
            // System.out.print("}");
            if( IntStream.of(cur).sum() == sum ) return 1;
            return 0;
        }

        int res1 = subsetSum(a, cur, j+1, sum);
        int temp[] = new int[cur.length+1];
        System.arraycopy(cur, 0, temp, 0, cur.length);
        temp[temp.length-1] = a[j];
        int res2 = subsetSum(a, temp, j+1, sum);
        return res1+res2;
    }
}
