package Recursion;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(5314));
    }

    public static int sumOfDigits(int n){
        if(n <= 9) return n;
        return n%10 + sumOfDigits(n/10);
    }
}
