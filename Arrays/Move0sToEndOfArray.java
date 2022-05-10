package Arrays;

public class Move0sToEndOfArray {
    public static void main(String[] args) {
        //int a[] = {3, 5, 0, 0, 4};
        int a[] ={0, 0, 0, 4};
        //pushZerosToEnd(a, a.length);        
        pushZerosToEnd(a, a.length);
        display(a);
    }

    static void pushZerosToEndOptimal(int[] arr, int n) {
        int count = 0;
        for(int i =0;i<n;i++){
            if(arr[i]!= 0){
            arr[i] += arr[count];
            arr[count] = arr[i] - arr[count];
            arr[i] -= arr[count];
            count++;
            }
        }
    }


    //Naive Solution
    static void pushZerosToEnd(int[] arr, int n) {
        int j = 0;
        for(int i=0;i<n;i++){
           if(arr[i]==0){
            while(arr[j] == 0){
                if(j==n-1) break;
                else j++;
            }
            arr[i] += arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] -= arr[j];
           }else{
               j++;
           }
        }
    }

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
      }
}
