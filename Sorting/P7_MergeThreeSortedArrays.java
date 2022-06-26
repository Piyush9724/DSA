package Sorting;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class P7_MergeThreeSortedArrays
{
    static void printSorted(ArrayList<Integer> list)
    {
        for(Integer x : list)
        System.out.print(x + " ");
    }
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- >0)
		{
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int c = sc.nextInt();
		    
		    int A[] = new int[a];
		    int B[] = new int[b];
		    int C[] = new int[c];
		    
		    for(int i = 0; i < a; i++)
		      A[i] = sc.nextInt();
		      
		    for(int i = 0; i < b; i++)
		      B[i] = sc.nextInt();
		      
		    for(int i = 0; i < c; i++)
		      C[i] = sc.nextInt();
		    
		    printSorted( MergeThreeSortedArrays.merge3sorted(A, B, C));
		    System.out.println();
		    
		}
        sc.close();
	}
}// } Driver Code Ends


//User function Template for Java

class MergeThreeSortedArrays
{
    // A[], B[], C[]: input arrays
    //Function to merge three sorted lists into a single list.
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        // add ypur code here
        int AB[] = new int[A.length+B.length];
        int ABC[] = new int[AB.length+C.length];
        
        AB = merge(A,B,AB);
        ABC = merge(AB,C,ABC);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<ABC.length;i++){
            res.add(ABC[i]);
        }
       return res;
        
    }
    
    static int[] merge(int L[], int R[],int X[]){
         /* Merge the temp arrays back into arr[l..r]*/
        int i = 0, j = 0, k = 0;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                X[k] = L[i];
                i++;
            } else {
                X[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of L[], if there are any */
        while (i < L.length) {
            X[k] = L[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of R[], if there are any */
        while (j < R.length) {
            X[k] = R[j];
            j++;
            k++;
        }
        return X;
    }
}
