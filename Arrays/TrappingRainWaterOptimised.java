package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class TrappingRainWaterOptimised {
    public static void main (String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        int n =  sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(TrappingRainWaterSolution2.trappingWater(arr, n));
        sc.close();
    }

}

class TrappingRainWaterSolution2{
    //Correct Approach One Time Complexity O(n^2) SC : O(N)
    static long trappingWater(int arr[], int n){
        long water = 0;
        int left =0, right = n-1;
        int maxLeft = arr[left];
        int maxRight = arr[right];
        
        while( left < right ){
            if( arr[left] <= arr[right] ){
                left++;
                maxLeft = Math.max(maxLeft, arr[left]);
                water += (maxLeft - arr[left]);
            } 
            else{
                right--;
                maxRight = Math.max(maxRight, arr[right]);
                water += (maxRight - arr[right]);
            }
        }
        return water;
    }
}

/*
ip 1 :
7
8 8 2 4 5 5 1

ip2 :
10
1 1 5 2 7 6 1 4 2 3

ip3:
8
8 0 0 5 9 2 3 5

ip:
4
7 4 0 9

ip
6
3 0 0 2 0 4

ip
7
8 8 2 4 5 5 1

ip
5
3 0 2 0 4
*/