package Maths;

public class ComputingPower {
    public static void main(String[] args) {
        //System.out.println(computePower(2, 10));
       // System.out.println(computePowerEfficient(2, 10));
        System.out.println(computeIterativePower(2, 10));
    }

    // Naive Solution Theta(x)
    public static long computePower(long x, long n) {
        if( n == 0 ) return 1;
        if( n == 1)  return x;
        long res = 1;
        while(n >= 1 ){
            res *= x; 
            n--;
        }
        return res;
    }

    // Efficient Solution Theta( sqrt(x)) )
    public static long computePowerEfficient(long x, long n) {
        if( n == 0 ) return 1;
        if( n % 2 ==0 ) return computePowerEfficient(x, n/2) * computePowerEfficient(x, n/2);
        else return computePowerEfficient(x, n-1) * x;
    }


    //Efficeint Solution with Iteration and using Bits 
    public static long computeIterativePower(long x, long n) {
        long res = 1;
        while(n>0){
            if( n % 2 != 0 ){
                res *=x;
            }
            x*=x;
            n/=2;
        }
        return res;
    }
}
