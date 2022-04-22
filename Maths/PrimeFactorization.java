package Maths;
import java.util.*;

public class PrimeFactorization {
    public static void main(String[] args) {
        ArrayList<Integer> primeFactors = findPrimeFactors( 5000 ,2);
        System.out.println("Prime Factors");
        for (Integer primeFactor : primeFactors) {
            System.out.print(primeFactor+ " ");
        }
        Set<Integer> set = new TreeSet<>(primeFactors);
        primeFactors.clear();
        primeFactors.addAll(set);
        System.out.println("\nUnique Prime Factors");
        for (Integer primeFactor : set) {
            System.out.print(primeFactor+ " ");
        }
    }   
    static ArrayList<Integer> primeFactors  =  new ArrayList<>();
    public static ArrayList<Integer> findPrimeFactors(int n, int i) {
        if(PrimeNumber.isPrimeEfficient(n)) {
            primeFactors.add(n);
            return primeFactors;
        }
        if( n <= 1) return primeFactors;
        
        if(PrimeNumber.isPrimeEfficient(i)) {
            if( n % i == 0){
                primeFactors.add(i);
                findPrimeFactors(n/i, 2);
            }else {
                findPrimeFactors(n, i+1);
            }
        } else {
            findPrimeFactors(n, i+1);
        }
        return primeFactors;
    }
}
