package Searching;

import java.util.*;
import java.awt.Point; 

public class A19_CountOnlyRepeatedElement {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    Integer arr[] = new Integer[n];
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    Point p= CountOnlyRepeatedElementSolution.findRepeating(arr,n);
            
            System.out.println(p.x +" "+ p.y ); 
		    
		}

        sc.close();
		
		
	}
}// } Driver Code Ends


//User function Template for Java

class CountOnlyRepeatedElementSolution
{
    //Function to find repeated element and its frequency.
    public static Point findRepeating(Integer arr[],int n)
    {
        //Your code here
        int l = 0, r = n-1;
        while(l<r){
            int m = (l+r)/2;
            if( arr[m] == m + arr[0]){
                 l = m+1;
            }else{
                 r = m;
            }
        }
        if( n - (arr[n-1]-arr[0]) > 1 )
            return new Point(l, n - (arr[n-1]-arr[0]));
        else
            return new Point(-1,-1);
        
    }  
};
