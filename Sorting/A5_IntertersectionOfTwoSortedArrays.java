package Sorting;

import java.util.*;
import java.io.*;


public class A5_IntertersectionOfTwoSortedArrays {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
                arr1[i] = Integer.parseInt(st[i]);
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < M; i++)
                arr2[i] = Integer.parseInt(st[i]);
                
            ArrayList<Integer> v = new ArrayList<Integer>();
            v = IntertersectionOfTwoSortedArraysSolution.printIntersection(arr1, arr2, N, M);
           
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+" ");
                
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class IntertersectionOfTwoSortedArraysSolution
{
    //Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> printIntersection(int arr[], int brr[], int n, int m) 
    {
        // add your code here
        if(n < m){
            return findIntersection(arr,brr,n,m);
        }else{
            return findIntersection(arr,brr,n,m);
        }
    }

    static ArrayList<Integer> findIntersection(int arr[], int brr[], int n, int m) 
    {
       ArrayList<Integer> res = new ArrayList<>();
       int i=0,j=0;
       while(i < n && j<m){
           if( (i>0 && arr[i] == arr[i-1]) || arr[i] < brr[j] ){
               i++;
           }else if( arr[i] > brr[j]){
               j++;
           }else{
               res.add(arr[i]);
               i++;
               j++;
           }
       }
        
        return res;
    }
    
    static ArrayList<Integer> findIntersectionWrong(int arr[], int brr[], int n, int m) 
    {
       ArrayList<Integer> res = new ArrayList<>();
       int i = 0,j = 0;
       while(i<n-1 || j< m-1){
            if( arr[i] == brr [j]){
                res.add(arr[i]);
                if( i == n-1 || j == m-1) break;
                i++;
                j++;
                while(i+1 < n && arr[i+1] == arr[i]) i++;
                while(j+1 < m && brr[j+1] == brr[j]) j++;
            }else if(arr[i] < brr[j] && i < n-1 && j<m-1) i++;
            else if(i< n-1 && j<m-1)j++;
            else break;
        }
        
        return res;
    }

}



/*
1
8 5
3 5 10 10 10 15 15 20
5 10 10 15 30
 */