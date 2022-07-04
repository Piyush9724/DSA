package Hashing;

import java.util.*;

class SubArrayWithGivenSumSolution {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> res =  new ArrayList<>();
        int curSum = 0, start = 1, end =0;
        for(int i=0;i<n;i++){
            curSum += arr[i];
            end++;
            if(curSum == s){
                res.add(start);
                res.add(end);
                return res;
            }
            while(curSum > s){
                start++;
                curSum  -= arr[start-2];
            }
        }
        res.add(-1);
        return res;
    }
}

public class A6_SubArrayWithGivenSum {
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
            ArrayList<Integer> res = SubArrayWithGivenSumSolution.subarraySum(m, n, s);
            for (int ii = 0; ii < res.size(); ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
        sc.close();
    }

}// } Driver Code Ends

/*
1
5 12
1 2 3 7 5
 */