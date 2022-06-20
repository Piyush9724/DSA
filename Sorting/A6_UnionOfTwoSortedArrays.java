package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A6_UnionOfTwoSortedArrays {
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
            v = UnionOfTwoSortedArraysSolution.findUnion(arr1, arr2, N, M);
           
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+" ");
                
            System.out.println();
        }
    }
}

class UnionOfTwoSortedArraysSolution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr[], int brr[], int n, int m)
    {
        // add your code here
        if(n <= m){
            return findUnion1(arr,brr,n,m);
        }else{
            return findUnion1(brr,arr,m,n);
        }
    }
    
    static ArrayList<Integer> findUnion1(int arr[], int brr[], int n, int m) 
    {
       ArrayList<Integer> res = new ArrayList<>();
       int i=0,j=0;
       while(i < n && j<m){
           if((i>0 && arr[i] == arr[i-1])) {
               i++;
               continue;
           }
           if((j>0 && brr[j] == brr[j-1])) {
               j++;
               continue;
           }
           if( arr[i] < brr[j] ){
                 res.add(arr[i]);
                 i++; 
           }else if( arr[i] > brr[j]){
               res.add(brr[j]);
               j++;
           }else{
               res.add(arr[i]);
               i++;
               j++;
           }
       }

       while(j<m){
           if((j>0 && brr[j] == brr[j-1])) {
               j++;
               continue;
           }
           res.add(brr[j]);
           j++;
       }  
       
       while(i<n){
        if((i>0 && arr[i] == arr[i-1])) {
            i++;
            continue;
        }
        res.add(arr[i]);
        i++;
    }   
        return res;
    }
}

/*
1
3 5
3 5 8
2 8 9 10 15



1
7 7                              
1 6 13 14 19 31 42
10 11 25 34 38 46 49

1
2 3
1 42
21 25 37
 */