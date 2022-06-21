package Sorting;

import java.io.*;
import java.util.*;
public class A11_KthSamllestElementQuickSelect {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    out.println(KthSmallestElementQuickSelectSolution.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
        sc.close();
	}
}

//The idea is to use quick select.
/*
To make the fastest Partitoning algo, we use randomized partition that
Randomly pick a pivot element.
To implement randomized partition, we use a random function,
rand() to generate index between l and r, 
swap the element at randomly generated index with the last element,
and finally call the standard partition process which uses last element as pivot.
 */

class KthSmallestElementQuickSelectSolution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code her
        
        if( k > 0 && k <= r-l +1){
           int p = partition(arr,l, r);
           if (p - l == k - 1)
                return arr[p];
           if (p - l > k - 1)
                return kthSmallest(arr, l, p - 1, k);
 
            // Else recur for right subarray
           return kthSmallest(arr, p + 1, r, k - p + l - 1);
        }
        return Integer.MAX_VALUE;
    } 

    static void random(int arr[],int low,int high) 
    { 
      
        int n = high-low+1;
        Random rd = new Random();
        int pivot = rd.nextInt(n);
          
        int temp1=arr[low+pivot];  
        arr[low+pivot]=arr[high]; 
        arr[high]=temp1; 
    } 
    
    static int partition(int arr[], int low, int high)
    {
        // your code here
        //Hoare's partition
        random(arr,low,high);
        int pivot = arr[high];
        int i = low-1;
        for(int j=low;j<=high;j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    } 

    
}
