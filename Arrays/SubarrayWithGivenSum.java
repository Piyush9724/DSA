package Arrays;

// { Driver Code Starts
import java.util.*;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }

            SubarrayWithGivenSumSolution obj = new SubarrayWithGivenSumSolution();
            ArrayList<Integer> res = obj.subarraySumEfficient(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}// } Driver Code Ends

class SubarrayWithGivenSumSolution {

    //Approach 2 Effiecient O(n) 
    static ArrayList<Integer> subarraySumEfficient(int[] arr, int n, int s) {
        ArrayList<Integer> res = new ArrayList<>();
        int curSum = 0, start = 1, end = 0;
        for(int i = 0; i < n; i++){
            curSum += arr[i];
            end++;
            while(curSum > s ){
                ++start;
                curSum -= arr[start-2];
            }
            if(curSum == s){
                res.add(start);
                res.add(end);
                return res;
            }
        }
        res.add(-1);
        return res;
    }

    //Approach 1 :  O(n) : Time Limit Exceeding
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        int i = 0, j = 0;
        // int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int curSum = 0;
        while (i < n) {
            if (curSum < s && j<n) {
                curSum += arr[j];
                j++;
            }
            if (curSum == s) {
                res.add(i + 1);
                res.add(j);
                return res;
            }
            if (curSum > s) {
                curSum -= arr[i];
                i++;
            }
        }
        res.add(-1);
        return res;
    }
}