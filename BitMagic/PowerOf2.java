package BitMagic;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(checkForPowerOf2(4));
    }

    public static boolean checkForPowerOf2(long n) {
        return ( n!=0 && ( n & (n-1) ) == 0 );        
    }
}
