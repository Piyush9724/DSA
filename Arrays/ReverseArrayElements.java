package Arrays;

public class ReverseArrayElements {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        reverse(a);
        display(a);
    }

    public static void reverse(int[] a){
        // write your code here
        for(int i =0; i<a.length/2;i++){
            a[i] += a[a.length-i-1];
            a[a.length-i-1] = a[i] - a[a.length-i-1];
            a[i] -= a[a.length-i-1];
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
