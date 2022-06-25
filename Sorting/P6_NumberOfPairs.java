package Sorting;

import java.util.*;
import java.io.*;
public class P6_NumberOfPairs {
    	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int g = 0;g < t;g++)
        {
            String[] str = (br.readLine()).trim().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            
            int[] x = new int[M];
            str = (br.readLine()).trim().split(" ");
            for(int i = 0;i< M;i++)
                x[i] = Integer.parseInt(str[i]);
                
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[N];
            for(int i = 0;i< N;i++)
            {
                y[i] = Integer.parseInt(str[i]);
                
            }
            System.out.println(NumberOfPairsSolution.countPairs(x, y, M, N));
           
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class NumberOfPairsSolution
{
    
    // x[], y[]: input array elements
    // M, N: size of arrays x[] and y[] respectively
    //Function to count number of pairs such that x^y is greater than y^x.
    static long countPairs(int x[], int y[], int M, int N)
    {
        // your code here
        Arrays.sort(x);
        Arrays.sort(y);
        int zeroes=0,ones=0,twos=0,threes=0, fours=0;
        for(int i=0;i<N;i++){
            if(y[i]==0) zeroes++;
            if(y[i]==1) ones++;
            if(y[i]==2) twos++;
            if(y[i]==3) threes++;
            if(y[i]==4) fours++;
        }
        
        long ans= 0;
        for(int i=0;i<M;i++){
            if(x[i]==0){
                continue;
            }else if(x[i] == 1){
                ans += zeroes;
            }else if( x[i] == 2){
                int index = find(y,N,x[i]);
                if( index != -1)
                    ans+= N-index;
                ans -= threes;
                ans -= fours; 
                ans+= zeroes+ones;
                
            }else{
                int index = find(y,N,x[i]);
                if( index != -1)
                    ans+= N-index;
                ans+= zeroes+ones;
                if(x[i]==3){
                    ans+=twos;
                }
            }
        }
        return ans;
    }
    
    static int find(int y[], int n, int x){
        int l = 0, h = n-1, pos = -1;
        while(l<=h){
            int m = l + (h-l) /2;
            if(y[m]>x){
                pos = m;
                h = m-1;
            }else{
                l = m+1;
            }
        }
        return pos;
    }
}

/*
1
3 2
2 1 6
1 5
 */