package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
         System.out.println(isPrime(35));
         System.out.println(isPrimeEfficient(35));
        //  int count = 100;
        //  int i = 2;
        //  while(count > 1){
        //      if( isPrimeEfficient(i)) {
        //          System.out.print(i+", ");
        //          count--;
        //      }
        //      i++;
        //  }
    }


    //This approach take number 2 to √n and search for number which completly divide the input
    //This approach is based on the Fact that the Divisors are always present in pairs 
    // for Ex: 30 Divisors are (1,30), (2,15), (3,10), (5,6), (6,5), (10,3), (15,2), (30,1)
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

    //This effiecent method saves many iterations by checking the divisibilty with 2 and 3 
    public static boolean isPrimeEfficient(int  n) {
        if(n == 1) return false;

        if( n == 2 || n == 3) return true;

        if( n % 2 == 0 || n % 3 == 0 ) return false;

        for(int i = 5 ; i <= Math.sqrt(n) ;i+=6) {
            if( n % i == 0 || n % (i+2) == 0 ) return false;
        } 
        return true;

    }
}
