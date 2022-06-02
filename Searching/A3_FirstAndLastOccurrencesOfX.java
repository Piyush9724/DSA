package Searching;

import java.util.*;
import java.io.*;

public class A3_FirstAndLastOccurrencesOfX {
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            FirstAndLastOccurrencesOfX ob = new FirstAndLastOccurrencesOfX();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

class FirstAndLastOccurrencesOfX{

    ArrayList<Long> find(long arr[], int n, int x){
        ArrayList<Long> firstLast = new ArrayList<>();
        if( binarysearch(arr, n, x) == -1){
            firstLast.add(Long.valueOf(-1));
            firstLast.add(Long.valueOf(-1));
        }else{
            firstLast.add(firstOccurence(arr, n, x));
            firstLast.add(lastOccurence(arr, n, x));
        }
        return firstLast;
    }

    public static int binarysearch(long arr[],int n, int x){
        int l=0,r=n-1;
        while(l<=r){
            int m  =  l + (r-l) /2;
            if( x == arr[m]) return m;
            if( x < arr[m]) r = m -1;
            else  l = m+1;
        }
        return -1;
    }

    public static Long firstOccurence(long arr[], int n, int x){
        int l = 0, r = n;
        while( l<r ) {
            int m = l + (r-l) /2;
            if( x <= arr[m]) r= m;
            else l = m+1;
        }
        return Long.valueOf(l);
    }

    public static Long lastOccurence(long arr[], int n, int x){
        int l = 0, r = n;
        while( l<r ) {
            int m = l + (r-l) /2;
            if( x >= arr[m]) l = m+1;
            else r = m;
        }
        return Long.valueOf(l-1);
    }
}



