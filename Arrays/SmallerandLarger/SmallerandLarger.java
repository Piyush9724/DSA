package Arrays.SmallerandLarger;

import java.util.*;

public class SmallerandLarger {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 8, 10, 11, 12, 19};
        int[] arr ={4,4,5,5,6};
        Solve s = new Solve();
        int res[] = s.getMoreAndLess(arr, 5, 6);
        System.out.println("Result is :: "+ res[0]+ " "+res[1]);
        // int res = binarySearch(arr, 0, 6, 23);
        // System.out.println(res);
    }
    public static int binarySearch(int arr[], int l, int r, int x) {
        if ( r < l) {
            return -1;
        }
        int mid = (int)(Math.floor((l+r)/2));
        if(arr[mid] == x){
            return mid;
        }
        if( arr[mid] > x){
            return binarySearch(arr, l, mid-1, x);
        }else{
            return binarySearch(arr,mid+1,r,x);
        }
    }

}



class Solve {
    private static int z = 0;
    int[] getMoreAndLess(int[] arr, int n, int x) {
        // code here
        n--;
        int i = binarySearch(arr, 0, n,x);
        if( i == -1){
            int res[] = {z, n-z+1};
            return res;
        }else{
            Set<int[]> s = new HashSet<>(Arrays.asList(arr));
            if(s.size() == 1){
                int res[] = {n+1,n+1};
                return res;
            }
            int res[] = {i+1, n-i+1};
            return res;
        }
    }

    private static int binarySearch(int arr[], int l, int r, int x) {
        if ( r < l) {
            z = l;
            return -1;
        }
        int mid = (int)(Math.floor((l+r)/2));
        if(arr[mid] == x){
            return mid;
        }
        if( arr[mid] > x){
            return binarySearch(arr, l, mid-1, x);
        }else{
            return binarySearch(arr,mid+1,r,x);
        }
    }
}
