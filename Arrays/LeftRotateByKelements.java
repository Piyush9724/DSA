package Arrays;

public class LeftRotateByKelements {
    public static void main(String[] args) {
        int arr[] ={10, 12, 8, 7, 9, 15};
        leftRotate(arr, 4, arr.length);
        //reverseArray(arr, 0, arr.length-1);
        display(arr);
        
    }

    static void leftRotate(int arr[], int k,int n)
    {
      k = k%n;
      reverseArray(arr, 0   , k-1);
      reverseArray(arr, k, n-1);
      reverseArray(arr, 0, n-1);
    }

    static void reverseArray(int arr[], int from, int to){
        while(from < to){
            arr[from] += arr[to];
            arr[to] = arr[from] -arr[to];
            arr[from] -= arr[to];
            from++;
            to--;
        }
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
      }

    static void leftRotateWrong(long arr[], int k,int n)
    {
        int N = n-1;
        int j = 0;
        for(int i=N;i>N-k;i--){
            arr[i]+=arr[N-k-j];
            arr[N-k-j] = arr[i] - arr[N-k-j];
            arr[i] -= arr[N-k-j];
            j++;
        }  
        j = k-1;
        for(int i=0;i<k;i++){
            arr[i] += arr[N-j];
            arr[N-j] = arr[i] - arr[N-j];
            arr[i] -= arr[N-j];
            j--;
        } 
    }


}

