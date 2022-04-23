package Maths;

public class DivisorsExactly3 {
    public static void main(String[] args) {
        System.out.println(exactly3DivisorsNaive(1000));
        System.out.println(exactly3Divisors(1000));
    }

    public static int exactly3DivisorsNaive(int N) {
         //Naive Approach exceeding Time for input 10^5
         if( N == 1 || N ==2 || N == 3 ) return 0;
         if( N < 7 ) return 1;
         int count = 0;
         int exact3 = 0;
         for( int i = 4;i<=N ; i++) {
             for(int j=2; j< (int)Math.sqrt(i);j++) {
                 if( i % j == 0) count++;
             }
             for(int j= (int)Math.sqrt(i); j< i;j++) {
                 if( i % j == 0) count++;
             }
             if(count == 1) exact3++;
             count = 0;
         }
 
         return exact3;
    }

    public static int exactly3Divisors(int N)
    {
        //Your code here        
        //Effiecient Approach
        int count = 0;
        for( int i=2;i*i<=N; i++ ) {
            if( PrimeNumber.isPrimeEfficient(i) ) {
                if( i*i <= N) count++;
            }
        }
        return count;

    }
}
