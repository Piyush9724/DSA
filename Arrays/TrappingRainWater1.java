package Arrays;

import java.io.IOException;
import java.util.Scanner;

public class TrappingRainWater1 {
    public static void main (String[] args) throws IOException {
        Scanner sc  = new Scanner(System.in);
        int n =  sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(TrappingRainWaterSolution1.trappingWater(arr, n));
        sc.close();
    }
}



class TrappingRainWaterSolution1{
    //Correct Approach One Time Complexity O(n^2) SC : O(N)
    static long trappingWater(int arr[], int n){
        long water = 0;
        int highLeft, highRight;
        for(int i=0;i<=n-1;i++){
            highLeft  = findLeftHighestNew(arr, 0, i, arr[i]);
            highRight = findRightHighestNew(arr, i, n-1, arr[i]);
            water += Math.min(arr[highLeft],arr[highRight]) - arr[i];
            System.out.println(i+": HighLeft :: "+highLeft+" HighRight :: "+highRight+ " Water :: "+water);
        }
        return water;
    }

    static int findLeftHighestNew(int arr[],int left,int right, int curBar){
        int highLeft = -1;
        int highLeftIndex = -1;
        for(int i=right; i >=left;i--){
            if( arr[i]>=curBar && arr[i]>highLeft){
                highLeft = arr[i];
                highLeftIndex = i;
            }
        }
        return highLeftIndex;
    }

    static int findRightHighestNew(int arr[],int left,int right, int curBar){
        int highRight = -1;
        int highRightIndex = -1;
        for(int i=left; i<=right;i++){
            if(arr[i]>=curBar && arr[i] > highRight){
                highRight = arr[i];
                highRightIndex = i;
            }
        }
        return highRightIndex;
    }
    //^ correct approach


    //Working for some test case but nor all
    static long trappingWaterWrongApproach(int arr[], int n) { 
        long water=0;
        int highLeft, highRight;
        for(int i=0;i<=n-1;i++){
             highLeft  = findLeftHighest(arr, 0, i-1, arr[i]);
             if(highLeft == -1) continue;
             highRight = findRightHighest(arr, i+1, n-1, arr[i]);
             if(highRight == -1) continue;
             int tiles = findTiles(arr, highLeft, highRight);
             water += ( ( Math.min(arr[highLeft],arr[highRight]) * ( highRight - (highLeft+1) )) - tiles);
             System.out.println(i+": HighLeft :: "+highLeft+" HighRight :: "+highRight+ " Water :: "+water);
             if(highLeft == 0 && highRight == n-1) break;
        }

        // highLeft  = findLeftHighest(arr, 0, 2, arr[3]);
        // highRight = findRightHighest(arr, 4, n-1, arr[3]);
        return water;
    }

    
    static int findLeftHighest(int arr[],int left,int right, int curBar){
        int highLeft = -1;
        int highLeftIndex = -1;
        for(int i=right; i >=left;i--){
            if( arr[i]>curBar && arr[i]>highLeft){
                highLeft = arr[i];
                highLeftIndex = i;
            }
        }
        return highLeftIndex;
    }

    static int findRightHighest(int arr[],int left,int right, int curBar){
        int highRight = -1;
        int highRightIndex = -1;
        for(int i=left; i<=right;i++){
            if(arr[i]>curBar && arr[i] > highRight){
                highRight = arr[i];
                highRightIndex = i;
            }
        }
        return highRightIndex;
    }

    static int findTiles(int arr[], int highLeft, int highRight){
        int tiles = 0;
        int minBar =  Math.min(arr[highLeft],arr[highRight]);
        for(int i = highLeft+1;i<highRight;i++){
            if(arr[i]> minBar) tiles += minBar;
            else tiles+=arr[i];
        }
        return tiles;
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