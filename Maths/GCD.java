package Maths;

public class GCD {
    public static void main(String[] args) {
        System.out.println(getGCD(35 , 105));
        System.out.println(euclidGCD(35, 105));
        System.out.println(optimizedEuclidsGCD(35, 105));
    }

    // Standard Algorithm
    public static int getGCD(int a, int b){
        int gcd  = 1;
        for( int i = (a < b? a:b); i >= 2 ;i--) {
            if( a%i == 0 && b%i == 0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }


    //Euclid's Algorithm
    public static int euclidGCD(int a, int b) {
        while( a != b) {
            if( a > b ){
                a -= b;
            }else {
                b-=a;
            }
        }
        return a; 
    }

    //Optimizsed Euclid Algo
    public static int optimizedEuclidsGCD(int a, int b) {
        if( b == 0 )
            return a;
        else    
            return optimizedEuclidsGCD(b, a%b);
    }
}
