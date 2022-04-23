package Maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//To Print all Prime numbers smaller or equal to N
public class SieveOfEratosthenes {
   public static void main(String[] args) {
       System.out.println(allPrimeNumbers(200));
       System.out.println(allPrimeNumberSieveOfEratosthenes(200));
       System.out.println(allPrimeNumberSieveOfEratosthenesEfficient(200));
   } 

   // Naive Solution  O( n * √n )
   public static List<Integer> allPrimeNumbers(int n) {
       List<Integer> allPrime = new ArrayList<>();
       for (int i = 2; i <= n ; i++) {
           if(PrimeNumber.isPrimeEfficient(i)) allPrime.add(i);
       }
       return allPrime;
    }

    // SieveOfEratosthenes O ( n log log n)
    public static List<Integer> allPrimeNumberSieveOfEratosthenes(int n) {
        List<Boolean> sieve =  new ArrayList<>(Collections.nCopies(n+1, Boolean.TRUE));
        for( int i =2 ; i <= Math.sqrt(n); i++) {
            if(PrimeNumber.isPrimeEfficient(i)) {
                for( int j = 2*i; j<=n;j+=i) sieve.set(j, Boolean.FALSE);
            }
        }
        List<Integer>  allPrime = new ArrayList<>();
        for(int i=2;i<=n;i++) {
            if( sieve.get(i) ) allPrime.add(i);
        }
        return allPrime;
    }

     // Effiecient SieveOfEratosthenes O ( n log log n)
     public static List<Integer> allPrimeNumberSieveOfEratosthenesEfficient(int n) {
        List<Boolean> sieve =  new ArrayList<>(Collections.nCopies(n+1, Boolean.TRUE));
        for( int i =2 ; i <= Math.sqrt(n); i++) {
            if(PrimeNumber.isPrimeEfficient(i)) {
                for( int j = i*i; j<=n;j+=i) sieve.set(j, Boolean.FALSE);
            }
        }
        List<Integer>  allPrime = new ArrayList<>();
        for(int i=2;i<=n;i++) {
            if( sieve.get(i) ) allPrime.add(i);
        }
        return allPrime;
    }
}
