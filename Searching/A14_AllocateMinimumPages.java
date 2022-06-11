package Searching;
import java.util.*;

public class A14_AllocateMinimumPages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            System.out.println(AllocateMinimumPagesSolution.findPages(a, n, m));
        }
        sc.close();
    }
}// } Driver Code Ends

// User function Template for Java

class AllocateMinimumPagesSolution {
    // Function to find minimum number of pages.
    public static int findPages(int[] A, int N, int M){
        int sum = 0, ans = Integer.MAX_VALUE;
        if( N < M) return -1;
        for(int i=0;i<N;i++)
            sum+=A[i];
        int l =0, r = sum;
        while(l <= r ){
            int m = (l + r) /2;
            if(checkPossibility(A, N,M,l,r,m)){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }


    public static boolean checkPossibility(int A[], int N, int M, int l, int r, int x){
        int curr_sum = 0, count =1;
        for(int i=0;i<N;i++){
            if( A[i] > x) return false;
            if( curr_sum + A[i] > x){
                count++;
                curr_sum = A[i];
                if(count > M) return false;
            }else{
                curr_sum+=A[i];
            }
        }
        return true;
    }


    //Wrong Approach
    public static int findPagesWrong(int[] A, int N, int M) {
        // Your code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        int r = N - 1;
        int p = A[r];
        int x = A[r];
        int count = 0;
        int grp = 0;
        int i = 0;
        boolean flag = false;
        while (!(mp.containsKey(x) && mp.get(x) == 2)) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            count = 0;
            while(i<N){
                while (i < N && grp + A[i] <= x ) {
                    grp += A[i];
                    i++;
                }
                count++;
                grp = 0;
            }
            if (count > M && !flag) {
                r--;
                p = A[r]/2;
                x += A[r];
                flag = true;
            } else if (count == M) {
                x -= p;
                p /= 2;
            } else if (count > M && flag) {
                x+=p;
                p/=2;
            }
            i = 0;
        }

        return x;
    }
}

/*
1
4
12 34 67 90
2

1
3
15 17 20
2

1
11
13 31 37 45 46 54 55 63 73 84 85
9
 */