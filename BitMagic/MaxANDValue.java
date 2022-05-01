package BitMagic;

public class MaxANDValue {
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {18, 15, 13, 12, 12, 11};
        // int N = 7;
        // int arr[] = { 18, 17, 16, 15, 14, 13, 12 };
        seeAND(arr, N);
        System.out.println(maxAND(arr, N));
    }
    //Wrong Approach
    public static int maxANDWrong (int arr[], int N) {
        
        // Your code here
        // You can add extra function (if required)
        int maxElement = 0;
        int maxElementIndex = 0;
        int maxAndValue=0;
        for(int i=0;i<N-1;i++){
            if(maxElement < arr[i]) {
                maxElement = arr[i];
                maxElementIndex = i;
            }
        }
        for(int i=0;i<N-1;i++) {
            if(i != maxElementIndex && ( ( maxElement & arr[i]) > maxAndValue ) ){
              maxAndValue = ( maxElement & arr[i]);
            }
        }
        return maxAndValue;
    }

    //Again Wrong approach
    public static int maxANDWrong2 (int arr[], int N) {
        
        // Your code here
        // You can add extra function (if required)
        int maxElement = 0;
        int maxElementIndex = 0;
        int maxAndValue=0;
        for(int i=0;i<N-1;i++){
            int res = 0;
            int x = arr[i];
            while( x > 0 ) {
                x = (x & ( x -1 ));
                res++;
            }
            System.out.println(i+":"+res);
            if(maxElement < res) {
                maxElement = res;
                maxElementIndex = i;
            }
        }
        System.out.println("max Element Index is ::"+ maxElementIndex);
       
        for(int i=0;i<N-1;i++) {
            if(i != maxElementIndex && ( ( arr[maxElementIndex] & arr[i]) > maxAndValue ) ){
              maxAndValue = ( arr[maxElementIndex] & arr[i]);
            }
        }
        return maxAndValue;
    }
    //Right approach but O(n^2) Complexity
    public static void seeAND(int arr[], int N) {
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-1;j++){
                if(i!=j){
                    int and = arr[i] & arr[j];
                    System.out.println(arr[i]+" & "+arr[j]+" :: "+ and);
                }
            }
            System.out.println("Comparing next elemnt");
        }
    }


    //Optimal Approach O(N* log m) where M is maximum element of array
    public static int maxAND (int arr[], int N) {
        
        // Your code here
        // You can add extra function (if required
        int res = 0;
        int pattern = 0;
        for(int bit=31;bit>=0;bit--){
            int value = (1<<bit);
            if(value < 0 ) value *= -1;
            pattern = pattern + value;
            
            int count = 0;
            for(int i=0; i<N; i++ ){
                if( (arr[i] & pattern) == pattern ) count++;
            }
            if( count >= 2) res += value;
            else  pattern -=  value;
        }
        return res;
    }


}
