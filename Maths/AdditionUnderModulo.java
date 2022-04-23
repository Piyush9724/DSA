package Maths;

public class AdditionUnderModulo {
    public static void main(String[] args) {
    
    }

    public static long additionUnderModulo(long a, long b) {
        return  (  ( a % ( (long)Math.pow(10,9) +7 ) ) + ( b % ( (long)Math.pow(10,9) +7 ) )  ) % ( (long)Math.pow(10,9) +7 ) ;
    }
}
