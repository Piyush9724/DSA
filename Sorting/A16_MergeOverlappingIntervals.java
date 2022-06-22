package Sorting;

import java.util.*;
import java.io.*;

public class A16_MergeOverlappingIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for (int i = 0; i < n; i++) {
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            MergeOverlappingIntervalsSolution2 obj = new MergeOverlappingIntervalsSolution2();
            int[][] ans = obj.overlappedInterval(Intervals);
            for (int i = 0; i < ans.length; i++) {
                for (j = 0; j < ans[i].length; j++) {
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

class Interval implements Comparable<Interval>
{ 
    int s, e;
    
    Interval(int s, int e)
    {
        this.s = s;
        this.e = e;
    }
    
    public int compareTo(Interval a)  
    { return this.s - a.s; }
};



class MergeOverlappingIntervalsSolution2
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        Interval[] arr =  new Interval[Intervals.length];
        for(int i=0;i<Intervals.length;i++){
            arr[i] =  new Interval(Intervals[i][0], Intervals[i][1]);
        }        
        int res = mergeIntervals(arr, arr.length);
        int[][] ans = new int[res+1][2];
        for(int i=0;i<=res;i++){
            ans[i][0] = arr[i].s;
            ans[i][1] = arr[i].e;
        }
        return ans;

    }
    static int mergeIntervals(Interval arr[], int n)  
    {  
        Arrays.sort(arr);  
      
        int res = 0;  
       
        for (int i=1; i<n; i++)  
        {  
            if (arr[res].e >=  arr[i].s)  
            {   
                arr[res].e = Math.max(arr[res].e, arr[i].e);  
                arr[res].s = Math.min(arr[res].s, arr[i].s);  
            }  
            else { 
                res++; 
                arr[res] = arr[i];  
            }     
        }  
        return res;
        // for (int i = 0; i <= res; i++)  
        //     System.out.print(  "[" + arr[i].s + ", " + arr[i].e + "] ");  
    } 
}











//////////
//Time Limit Exceeded
class MergeOverlappingIntervalsSolution1 {
    public int[][] overlappedInterval(int[][] Intervals)
        {
            // Code here // Code here
            return findOverlapped(Intervals);
        }
    public int[][] findOverlapped(int[][] Intervals)
        {
            ArrayList<Integer[]> res = new ArrayList<>();
            Arrays.sort(Intervals,Comparator.comparingInt(o->o[0]));
            boolean merged = false;
            for(int i=1;i<Intervals.length;i++){
                if(Intervals[i][0]<Intervals[i-1][1] && Intervals[i-1][1]<Intervals[i][1]){
                    Integer a[] = {Intervals[i-1][0],Intervals[i][1]};
                    res.add(a);
                    i++;
                    merged = true;
                }
                else{
                    Integer a[] = {Intervals[i-1][0],Intervals[i-1][1]};
                    res.add(a);
                    Integer b[] = {Intervals[i][0],Intervals[i][1]};
                    res.add(b);
                }
            }
            int[][] overlapped = new int[res.size()][2];
            for(int i=0;i<res.size();i++){
                overlapped[i][0] = res.get(i)[0];
                overlapped[i][1] = res.get(i)[1];
            }
            if(merged) findOverlapped(overlapped);
            return overlapped;
        }
}