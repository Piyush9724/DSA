package Hashing;

import java.io.*;
import java.util.*;

class LongestCommonSpanWithSameSumIn2BinArr {
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        // code here
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = arr1[i] == arr2[i]? 0:(arr1[i]?1:-1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        map.put(sum,-1);
        for(int i=0;i<n;i++){
            sum += a[i];
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}

public class A9_LongestCommonSpanWithSameSumIn2BinArr {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new LongestCommonSpanWithSameSumIn2BinArr().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
1
6
0 1 0 0 0 0
1 0 1 0 0 1
 */