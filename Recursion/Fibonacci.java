package Recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(7  ));
        System.out.println(fibonacci2(7));
    }

    public static int fibonacci(int n){
        if( n == 1 || n == 2 ) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci2(int n){
        if( n <=1 ) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
