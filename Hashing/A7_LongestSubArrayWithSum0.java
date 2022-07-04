package Hashing;

import java.util.*;

class LongestSubArrayWithSum0 {
    int maxLen(int arr[], int n) {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map =  new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen  = Math.max(maxLen, len);
            }else{
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
    int maxLenWrong(int arr[], int n) {
        // Your code here
        Set<Integer> hs = new HashSet<>();
        // Map<Integer, Integer> map = new HashMap<>();
        //List<Integer> ls = new ArrayList<>();
        int sum = 0, res = 0, resSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hs.contains(sum)) {
                if (sum >= resSum) {
                    resSum = sum;
                    res = i;
                }
                // map.put(i,sum);
            }
            hs.add(sum);
        }
        if (res == 0) {
            return 0;
        } else {
            int s = 0;
            for (int i = 0; i < n; i++) {
                s += arr[i];
                if (s == resSum) {
                    return res - i;
                }
            }
            return 0;
        }
    }
}

public class A7_LongestSubArrayWithSum0 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            LongestSubArrayWithSum0 g = new LongestSubArrayWithSum0();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
        sc.close();
    }
}// } Driver Code Ends

/*
1
8
15 -2 2 -8 1 7 10 23
 */