package Recursion;

public class SumOfFirstN_NaturalNo {
    public static void main(String[] args) {
        System.out.println(sumOfN(10));
    }

    public static int sumOfN(int n) {
        if( n == 0 ) return 0;
        return n + sumOfN(n-1);
    }
}
