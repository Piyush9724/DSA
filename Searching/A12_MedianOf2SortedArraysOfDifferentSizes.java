package Searching;

import java.util.*;

class MedianOf2SortedArrays 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        if( n <= m){
            return findMedian(n,m,a,b);
        }
        else{
            return findMedian(m,n,b,a);
        }
    }
    static double findMedian(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
       int l = 0, r= n;
       while(l<=r){
           int i1 = (l+r)/2;
           int i2 = ((n+m+1)/2) -i1;

           int min1 = ( i1 == n)? Integer.MAX_VALUE : a[i1];
           int max1 = ( i1 == 0)? Integer.MIN_VALUE : a[i1-1];

           int min2 = ( i2 == m)? Integer.MAX_VALUE : b[i2];
           int max2 = ( i2 == 0)? Integer.MIN_VALUE : b[i2-1];


           if( max1 <= min2 && max2 <= min1){
               if( (n+m)%2 == 0 ){
                return ((double)Math.max(max1, max2) + Math.min(min1, min2)) / 2;
               }
               else{
                return (double) Math.max(max1, max2);
               }
           }else if( max1 > max2){
              r = i1 -1;
           } else l = i1+1;
       }
     return -1;
    }
}

public class A12_MedianOf2SortedArraysOfDifferentSizes
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = MedianOf2SortedArrays.medianOfArrays(n, m, a, b);
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
        sc.close();
    		
	} 
}// } Driver Code Ends


/*
1
5
10 20 30 40 50
9
5 15 25 35 45 55 65 75 85 


1
3
10 20 30
5
5 15 25 35 45

 */