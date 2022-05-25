package Arrays;

import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n =  sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        } 
        System.out.println(FindMaxSubArraySum.maxSubarraySum(arr, n));
        sc.close();
    }

}

class FindMaxSubArraySum {

    //Kadane's Algorithm
    static long maxSubarraySum(int arr[], int n){
        // Your code herelong maxSum = arr[0];
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        int i = 0;
        while(i<n){
            sum += arr[i];
            maxSum = Long.max(sum,maxSum);
            if (sum < 0 ) sum = 0;
            i++;
        }
        return maxSum;  
    }



    static long maxSubarraySumWrong(int arr[], int n){
        
        // Your code here
        long maxSum = arr[0];
        long sum = arr[0];
        int i = 1;
        while(i<n){
           if( sum+arr[i] > maxSum ){
               maxSum = sum+arr[i];
               sum += arr[i];
               i++;
           }else{
               if(sum + arr[i] >= 0)
                    sum += arr[i];
                else 
                    sum = 0;
               i++;
           }
        }
        return maxSum;

        
    }
}


/* Ip
5
1 2 3 -2 5

7
1 -2 -3 4 -1 2 1

*/