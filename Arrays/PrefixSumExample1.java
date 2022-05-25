package Arrays;

public class PrefixSumExample1 {
    static int prefixArr[];
    public static void main(String[] args) {
        int arr[] = {2,8,3,9,6,5,4};
        prefixSum(arr, arr.length);
        System.out.println(getSum(4,6));
    }

    public static int getSum(int l, int r) {
        if( l == 0) return prefixArr[r];
        return prefixArr[r]-prefixArr[l-1];
    }


    public static void prefixSum(int arr[], int n){
        prefixArr = new int[n];
        prefixArr[0] = arr[0];
        for(int i=1;i<n;i++){
            prefixArr[i] = prefixArr[i-1]+arr[i];
        }
    }
}
