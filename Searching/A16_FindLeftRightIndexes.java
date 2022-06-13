package Searching;

import java.io.*;

class Pair  {  
    long first, second;  
    public Pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

public class A16_FindLeftRightIndexes {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            Pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}

class Solution {
    
    public Pair indexes(long v[], long x)
    {
        // Your code goes here
        Pair p;
        if( find(v, x) )
            p = new Pair(Long.valueOf(findLeft(v,x)),Long.valueOf( findRight(v,x)));
        else
            p = new Pair(Long.valueOf(-1), Long.valueOf(-1) );
        return p;
    }

    static boolean find(long v[], long x){
        int l = 0, r = v.length-1;
        while(l<=r){
           int m = l+(r-l)/2;
           if( x == v[m]) return true;
           if( x < v[m]){
               r = m-1;
           }else{
               l = m+1;
           }
        }
        return false;
    }

    
    static int findLeft(long v[], long x){
        int l = 0, r = v.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(x <= v[m]){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    static int findRight(long v[], long x){
        int l = 0, r = v.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(x >= v[m]){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
}