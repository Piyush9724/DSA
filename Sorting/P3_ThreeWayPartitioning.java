package Sorting;

import java.io.*;
import java.util.*;

public class P3_ThreeWayPartitioning {
    public static void main(String[] args)throws IOException {
        BufferedReader read= new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
         
        while(t-->0)
        {
            int N = Integer.parseInt(read.readLine());
            int array[] = new int[N];
            Map<Integer, Integer> mp = new HashMap<>();
            
            String input_line[] = read.readLine().trim().split(" ");
            for(int i=0;i<N;i++)
            {
                array[i] = Integer.parseInt(input_line[i]);
                if (mp.containsKey(array[i]))  
                { 
                    mp.put(array[i], mp.get(array[i]) + 1); 
                }  
                else
                { 
                    mp.put(array[i], 1); 
                } 
            }
            
            input_line = read.readLine().trim().split(" ");
            int a = Integer.parseInt(input_line[0]);
            int b = Integer.parseInt(input_line[1]);
        
            int original[] = new int[N];
            
            for(int i=0; i<N;i++)
            {
                original[i] = array[i];
            }

            int k1=0,k2=0,k3=0;
            int kk1=0;int kk2=0;int kk3=0;

            for(int i=0;i<N;i++)
            {
                if(original[i]>b)
                    k3++;
                else if(original[i]<=b && original[i]>=a)
                    k2++;
                else if(original[i]<b)
                    k1++;
            }
            ThreeWayPartitioningSolution ob = new ThreeWayPartitioningSolution();
            ob.threeWayPartition(array,a,b);

            for(int i=0;i<k1;i++)
            {
                if(array[i]<b)
                kk1++;
            }
            
            for(int i=k1;i<k1+k2;i++)
            {
                if(array[i]<=b && array[i]>=a)
                kk2++;
                
            }
            
            for(int i=k1+k2;i<k1+k2+k3;i++)
            {
                if(array[i]>b)
                kk3++;
            }
            Boolean ok = false;
            if(k1==kk1 && k2 ==kk2 && k3 == kk3)
                ok = true;

            for(int i=0;i<array.length;i++)
                mp.put(array[i], mp.get(array[i]) - 1);
            
            for(int i=0;i<array.length;i++)
                if(mp.get(array[i])!=0)
                    ok=false;
            
            if(ok)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class ThreeWayPartitioningSolution{
    //Function to partition the array around the range such 
    //that array is divided into three parts.
    public void threeWayPartition(int array[], int a, int b)
    {
        // code here 
        int l = 0, m = 0;
        int r = array.length-1;
        
        while(m<=r){
            if(array[m] < a){
                swap(array,m,l);
                m++;
                l++;
            }else if( array[m] >= a && array[m] <= b){
                m++;
            }else if( array[m] > b){
                swap(array,m,r);
                r--;
            }
        }
    }
    
    public static void swap(int a[], int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
