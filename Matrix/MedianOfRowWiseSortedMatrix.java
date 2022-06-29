package Matrix;

import java.io.*;
import java.util.*;

class MedianOfRowWiseSortedMatrixSolution {
    int median(int matrix[][], int r, int c) {
        // code here 
        int min = matrix[0][0], max = matrix[0][c-1];
        for(int i=0;i<r;i++){
            min = Integer.min(min, matrix[i][0]);
            max = Integer.max(max, matrix[i][c-1]);
        }
        
        int medianPos = (r*c+1)/2;
        while(min < max){
            int mid = min +(max-min)/2, midPos = 0;
            // Find count of elements smaller than or equal
            // to mid
            for(int i=0;i<r;++i){
                int pos = Arrays.binarySearch(matrix[i],mid);
                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if(pos < 0){
                    pos = Math.abs(pos)-1;
                }
                 // If element is found in the array it
                // returns the index(any index in case of
                // duplicate). So we go to last index of
                // element which will give  the number of
                // elements smaller than the number
                // including the searched element.
                else{
                   while (pos < matrix[i].length
                           && matrix[i][pos] == mid)
                        pos += 1;
                }
                midPos += pos;
            }
            
            if(midPos < medianPos){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }
    
}

/*
1
3 11
5 6 6 7 8 10 10 10 12 20 20 2 6 8 9 11 15 17 18 19 19 19 6 7 8 8 9 9 11 13 16 16 19

 */


public class MedianOfRowWiseSortedMatrix {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            MedianOfRowWiseSortedMatrixSolution ob = new MedianOfRowWiseSortedMatrixSolution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

