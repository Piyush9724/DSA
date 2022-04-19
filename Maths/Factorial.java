package Maths;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static long factorial(int N) {
        // Your code here
        if(N == 0) return 1;
        else{
            return N * factorial(N-1);
        }
    }
}
