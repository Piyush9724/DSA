package Sorting;

import java.io.*;

class BinaryArraySort
{
    //Function to sort the binary array.
    static void binSort(int A[], int N)
    {
        // add your code here
        if(N == 1) return;
        
        int i=-1, j=N;
        
        while(true){
            do{
                i++;
            }while(i<N && A[i]==0);
            do{
                j--;
            }while(j>=0 && A[j]==1);
            if(i>=j) return;
            A[i] += A[j];
            A[j] = A[i]-A[j];
            A[i] -= A[j];
        }
        
        /**************
        * No need to print the array
        * ************/
    }
}




public class P1_BinaryArraySorting {
    public static void main(String args[])throws IOException
    {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading testcases count
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)       {
            
            String st[] = read.readLine().trim().split(" ");
            
            //reading size of array 
            int N =Integer.parseInt(st[0]);
            
            //creating a new array of size n
            int A[] = new int[N];
            st = read.readLine().trim().split(" ");
            
            //adding elements to the array
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st[i]);
                
            //calling the method binSort() of
            //class BinarySort()
            BinaryArraySort.binSort(A, N);
            
            //printing the elements of array
            for(Integer x: A)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}