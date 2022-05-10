package Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        //int arr[] = {1,3,66,77,33,88,78,3,4,5};
        int arr[] = {1,1,1};
        System.out.println(findSeocndLargestElement(arr, arr.length));
    }

    public static int findSeocndLargestElement(int arr[], int n){
        int large = Integer.MIN_VALUE;
        int sLarge = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] > large){
                sLarge = large;
                large = arr[i];
            }else if(arr[i] != large && arr[i] > sLarge) {
                sLarge = arr[i];
            }
        }
        return sLarge;
    }
}
