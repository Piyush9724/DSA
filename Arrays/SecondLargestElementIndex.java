package Arrays;

public class SecondLargestElementIndex {
    public static void main(String[] args) {
        
    }

    public static int secondLargestElementIndex(int arr[], int n){
        int large = 0;
            int sLarge  = -1;
            for(int i =1;i<n;i++){
                if(arr[i]>arr[large]){
                    sLarge = large;
                    large = i;
                }else if( arr[i] != arr[large] && ( sLarge ==-1 || arr[i] > arr[sLarge]) ){
                    sLarge = i;
                }
            }
            return sLarge;
    }
}
