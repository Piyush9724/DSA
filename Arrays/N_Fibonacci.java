package Arrays;

public class N_Fibonacci {
    public static void main(String[] args) {
        bonacciSeries(3, 8);
        //bonacciSeriesSlidingWindow(3, 8);
        bonacciSeriesSlidingWindow(4, 10);
    }

    //Naive Approach
    public static void bonacciSeries(int n, int m){
        int a[] = new int[m];
        a[n-1] = 1;
        for( int i= n;i<m;i++){
            for( int j = i - n;j<i;j++){
                a[i] += a[j];
            }
        }
        for(int i=0;i<m;i++){
            System.out.print(a[i]+ " ");
        }
    }


    public static void bonacciSeriesSlidingWindow(int n, int m){
        int a[] = new int[m];
        a[n-1] = 1;
        a[n] = 1;
        for(int i = n+1;i<m;i++){
            a[i] = 2 *  a[i-1] - a[i-n-1];
        }
        for(int i=0;i<m;i++){
            System.out.print(a[i]+" ");
        }
    }
}
