package Arrays;

import java.io.*;

public class MaximumIndex {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // size of array
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
            }

            MaximumIndexSolution ob = new MaximumIndexSolution();

            System.out.println(ob.maxIndexDiff(arr, n)); // print the result
        }
    }
}// } Driver Code Ends

class MaximumIndexSolution {

    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N) {

        // Your code here
       int lmin[] = new int[N];
       int rmax[] = new int[N];
       lmin[0] = A[0];
       for(int i=1;i<N;i++){
           lmin[i] = Integer.min(A[i], lmin[i-1]);
       }
       rmax[N-1] = A[N-1];
       for(int i=N-2;i>=0;i--){
         rmax[i] = Integer.max(A[i], rmax[i+1]);
       }

       int i=0,j=0, res = -1;
       while(i<N && j<N){
           if(lmin[i]<=rmax[j]){
                res=  Integer.max(res, j-i);
                j++;
           }else{
               i++;
           }
       }

       return res;

    }
}


/*
1
9
34 8 10 3 2 80 30 33 1

1
2
1 10

1
17
35 98 95 94 75 8 47 28 75 91 28 83 72 54 67 9 34


*/