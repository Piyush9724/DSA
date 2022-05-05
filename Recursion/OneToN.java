package Recursion;

public class OneToN {
    public static void main(String[] args) {
        printSequnce1ToN(10);
        System.out.println();
        printSequnceNTo1(10);
        System.out.println();
        printSequnce1ToNTailRecursive(10, 1);
    }
    // Tail recursive N to 1 Takes less time and overhead
    public static void printSequnceNTo1(int n) {
        if ( n == 0 ) return;
        System.out.print(n+" ");
        printSequnceNTo1(n-1);
    }

    //Not a tail recurisive function 1 to N  Takes comparatively more time and overhead
    public static void printSequnce1ToN(int n) {
        if( n == 0 ) return;
        printSequnce1ToN(n-1);
        System.out.print(n+ " ");
    }

    //ail recurisive function 1 to N  Takes less time and overhead
    public static void printSequnce1ToNTailRecursive(int n, int k) {
        if ( n == 0) return;
        System.out.print(k+ " ");
        printSequnce1ToNTailRecursive(n-1, k+1);
    }
}
