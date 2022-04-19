package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
         System.out.println(isPrime(49));
    }

    public static boolean isPrime(int N) {
        // code here
        if ( N == 0 || N == 1 ) return false;
        if ( N ==2 || N == 3 ) return true;
       // prime number can be represented by this not otherwise
        // if ( ( ( ( N - 1 ) % 6 ) == 0 ) || ( ( ( N + 1 ) % 6 ) == 0 ) ) return true; 
       // else return false;
        for (int i = 2; i <= Math.sqrt(N); i++) { //efficiency matters
            if (N % i == 0) {
                return false;
            }
       }
        return true;

    }
}
