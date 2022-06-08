package Searching;

import java.io.*;
import java.util.HashMap;

public class A9_CountPairsWithGIvenSumInUnsortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new CountPairsWithGIvenSumInUnsortedArray().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class CountPairsWithGIvenSumInUnsortedArray {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int count = 0;
        HashMap<Integer, Integer> pairsMap = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(pairsMap.containsKey(k-arr[i])){
                count += pairsMap.get(k-arr[i]);
            }
            pairsMap.put(arr[i], pairsMap.getOrDefault(arr[i], 0)+1);
        }
        return count;
    }
}
