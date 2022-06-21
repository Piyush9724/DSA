package Sorting;

import java.io.*;

public class A13_ReArrangeNegativePositiveWithoutOrder {
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
            
            
          //  ReArrangeNegativePositive.Rearrange(a, n);
           // ReArrangeNegativePositive.RearrangeWithOrder(a, n);
            ReArrangeNegativePositive.rearrangeWithHoaresPartitionWithoutOrder(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class ReArrangeNegativePositive {
    
    public static void RearrangeWithoutOrder(long a[], long n)
    {
        // Your code goes here
        int i=0,j=(int)n-1;
        while(i<=j){
            if( a[i] < 0 && a[j] < 0) i++;
            else if( a[i] >0 && a[j] < 0){
                long temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }else if(a[i] >0 && a[j] > 0) j--;
            else{
                i++;
                j--;
            }
        }
    }

    public static void rearrangeWithHoaresPartitionWithoutOrder(long a[], long n){
        int i=-1, j=a.length;
        while(true){
            do{
                i++;
            }while(a[i] < 0);
            do{
                j--;
            }while(a[j] >= 0);
            if(i>=j) return;
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}