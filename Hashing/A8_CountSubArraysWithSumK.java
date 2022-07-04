package Hashing;

import java.io.*;
import java.util.*;

class CountSubArraysWithSumK
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        map.put(sum,1);
        for(int i=0;i<N;i++){
            sum += Arr[i];
            if( map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }   
        
        return count;
        
    }
}

public class A8_CountSubArraysWithSumK {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            System.out.println(CountSubArraysWithSumK.findSubArraySum(Arr, N, k));
        }
    }
}// } Driver Code Ends


/*
1
5
10 2 -2 -20 10
-10



1
5
1 -7 4 -3 -3
-3
 */