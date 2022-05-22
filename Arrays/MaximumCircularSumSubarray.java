package Arrays;

import java.util.Scanner;

public class MaximumCircularSumSubarray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n =  sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        } 
        System.out.println(FindMaxCircularSubArraySum.circularSubarraySum(arr, n));
        sc.close();
    }
}

class FindMaxCircularSubArraySum {


    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        //System.out.println(kadane(a,n));
        //System.out.println(reverseKadane(a,n));
        if(n == 1) return a[0];
        int maxNegative = Integer.MIN_VALUE;
        boolean checkPositive = false;
        for(int i=0;i<n;i++){
            if(a[i]>0){
                checkPositive = true;
                break;
            }else{
                maxNegative = Integer.max(a[i], maxNegative);
            }
        }
        if(checkPositive)
            return Integer.max(kadane(a,n), reverseKadane(a,n));
        else
            return maxNegative;
    }
    static int kadane(int arr[], int n){
        // Your code herelong maxSum = arr[0];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        while(i<n){
            sum += arr[i];
            maxSum = Integer.max(sum,maxSum);
            if (sum < 0 ) sum = 0;
            i++;
        }
        return maxSum;  
    }

    static int reverseKadane(int arr[], int n){
        // Your code herelong maxSum = arr[0];
        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        while(i<n){
            totalSum+= arr[i];
            sum += arr[i];
            minSum = Integer.min(sum,minSum);
            if (sum > 0 ) sum = 0;
            i++;
        }
        System.out.println("Minimum Sum :: "+ minSum);
        return totalSum-minSum;  
    }



    //Wrong Approach to go round using modulo operator, that is right if we want to use O(n^2) approach
    static int reverseKadaneWrong(int arr[], int n){
        // Your code herelong maxSum = arr[0];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = n-1;
        int j = 0;
        while(j<n){
            sum += arr[i%n];
            maxSum = Integer.max(sum,maxSum);
            if (sum < 0 ) sum = 0;
            i++;
            j++;
        }
        return maxSum;  
    }
}
