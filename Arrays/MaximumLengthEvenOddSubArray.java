package Arrays;

public class MaximumLengthEvenOddSubArray {
    public static void main(String[] args) {
        //int arr[] = {10,12,14,7,8};
       // int arr[] = {7,10,13,14};
        int arr[] = {10,12,8,4};
        System.out.println(findMaxEvenOddSubArrayLength(arr, arr.length));
        
    }

    public static int findMaxEvenOddSubArrayLength(int arr[], int n){
        int maxSubArrayLength = 1;
        int subArrayLength = 1;
        int i=1;
        boolean check = checkEvenOdd(arr[0]);
        while(i<n){
            if( checkEvenOdd(arr[i])  ==  !check ){
                subArrayLength++;
                maxSubArrayLength =  Integer.max(subArrayLength, maxSubArrayLength);
                check = !check;
            }else{
                check = checkEvenOdd(arr[i]);
                subArrayLength = 1;
            }
            i++;
        }
        return maxSubArrayLength;
    }

    public static boolean checkEvenOdd(int x){
        return x % 2 == 0?true:false;
    }


}
