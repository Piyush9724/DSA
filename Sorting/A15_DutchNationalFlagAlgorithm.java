package Sorting;
import java.io.*;

class DutchNationalFlag
{
    public static void sort012(int a[], int n)
    {
        // code here 
        int l = 0,  r= n-1;
        int m = 0;
        
        while(m <= r){
            if(a[m] == 0){
                swap(a,m,l);
                m++;
                l++;
            }
            else if(a[m] == 1) m++;
            else if(a[m] == 2){
                swap(a,m, r);
                r--;
            }
        }
    }
    
    public static void swap(int a[],int i,int j){
        int temp = a[i];
        a[i]= a[j];
        a[j] = temp;
    }
}

// { Driver Code Starts.

    public class A15_DutchNationalFlagAlgorithm {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            DutchNationalFlag.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends