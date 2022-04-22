package Maths;

import java.util.ArrayList;
import java.util.List;

public class AllDivisors {
    public static void main(String[] args) {
        for (Integer divisor : allDivisors(100)) {
            System.out.print(divisor+" ");
        }
        System.out.println("Now Efficient Solution");
        for (Integer divisor : allDivisorsEfficient(100)) {
            System.out.print(divisor+" ");
        }
        System.out.println("Now SortedEfficient Solution ");
        for (Integer divisor : allDivisorsEfficientSorted(100)) {
            System.out.print(divisor+" ");
        }
    }

    //Naive Solution
    public static List<Integer> allDivisors(int n) {
        List<Integer> allDivisors = new ArrayList<>();
        for(int i = 1; i <= n ; i++ ) {
            if( n % i == 0 ) allDivisors.add(i);
        }
        return allDivisors;
    }


    //Effiecient Solution not in Sorted Order
    public static List<Integer> allDivisorsEfficient(int n) {
        List<Integer> allDivisors = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n) ; i++ ) {
            if( n % i == 0 ) {
                allDivisors.add(i);
                if( n/i != i)
                    allDivisors.add(n/i);
            }
        }
        return allDivisors;
    }

    //Effiecient Solution in Sorted Order
    public static List<Integer> allDivisorsEfficientSorted(int n) {
        List<Integer> allDivisors = new ArrayList<>();
        for(int i = 1; i < Math.sqrt(n) ; i++ ) {
            if( n % i == 0 ) {
                allDivisors.add(i);
            }
        }
        for(int i = (int)Math.sqrt(n); i <= n ; i++ ) {
            if( n % i == 0 ) {
                allDivisors.add(i);
            }
        }
        return allDivisors;
    }

}
