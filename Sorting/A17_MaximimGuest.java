package Sorting;

import java.util.*;


public class A17_MaximimGuest {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
            MaximumGuestSolution ob= new MaximumGuestSolution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
        sc.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class MaximumGuestSolution
{
    public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        Arrays.sort(Entry);
        Arrays.sort(Exit);
        int res[] = new int[2];
        int i=0,j=0;
        int curPer = 0, maxPer = 0;
        int time=0;
        while(i<N){
            if(Entry[i]<=Exit[j]){
                curPer++;
                if(curPer > maxPer){
                    time = Entry[i];
                    res[1] = time;
                    maxPer = curPer;
                    res[0] = maxPer;
                }
                i++;
            }else if(Exit[j] < Entry[i]){
                curPer--;
                j++;
            }
        }
        return res;
	}
}