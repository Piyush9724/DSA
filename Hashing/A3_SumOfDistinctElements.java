package Hashing;


import java.util.*;
import java.util.stream.Collectors;
import java.io.*;



class SumOfDistinctElementsSolution {
    int findSum(int arr[], int n) {
        // code here
        Set<Integer> s = new HashSet<>( Arrays.stream(arr).boxed().collect(Collectors.toList()) );
        int sum = s.parallelStream().reduce(0,(x,y)-> x+y);
        return sum;

        /* 
        int sum = 0;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++)
            s.add(arr[i]);
        for(Integer i : s)
            sum += i;
        return sum;
        */
    }
}


public class A3_SumOfDistinctElements {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new SumOfDistinctElementsSolution().findSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

