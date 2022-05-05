package Recursion;

public class RopeCuttingMaximumPiece {
    public static void main(String[] args) {
      // System.out.println(ropeCut(5, 2, 5, 1));
       System.out.println(ropeCut(23, 12, 9, 11));
      // System.out.println(ropeCut(5, 4, 2, 6));
    }

    // Optimal and right approach  O(3 ^ n)
    public static int ropeCut(int n, int a, int b, int c){
        if( n == 0 ) return 0 ;
        if( n < 0 ) return -1;
        int res = getMax(ropeCut(n-a, a, b, c), ropeCut(n-b, a, b, c), ropeCut(n-c, a, b, c));
        if ( res == -1 ) return -1;
        return res + 1;
    }

    public static int getMax(int a,int b, int c) {
        if( a > b && a > c) return a;
        if( b > a && b > c) return b;
        else return c;
    }

    //wrong approach 3
    public static int ropeCutWrong3(int n, int a, int b, int c) {
    
            if( a > b ){
                a = a-b;
                b = a + b;
                a = b - a;
            }
            if( a > c ){
                a = a-c;
                c = a + c;
                a = c - a;
            }
            if( b > c ){
                b= b-c;
                c = b + c;
                b = c - b;
            }
        if( n - a  < 0 ) {
            if( n - b < 0 ){
                if( n - c < 0 ){
                    return 0;
                }else{
                    return 1 + ropeCutWrong3(n-c, a, b, c);
                }
            } else{
                return 1 + ropeCutWrong3(n - b, a, b, c);
            }
        }else{
            return 1 + ropeCutWrong3(n-a, a, b, c);
        }
    }

    public static int ropeCutWrong2(int n, int a, int b, int c) {
        if( n <= 0) return 1;
        //int cutWith = 0;
        int shortestCut = n;
        if( n % a < shortestCut){
            shortestCut = n%a;
            return 1 + ropeCutWrong2(n-a, a, b, c);
        }
        if( n % b < shortestCut){
            shortestCut = n%b;
            int r = ropeCutWrong2(n-b, a, b, c);
            if( r == -1) return 1 ;
            else return 1 + r;
        }
        if( n % b < shortestCut){
            shortestCut = n%b;
            return 1 + ropeCutWrong2(n-b, a, b, c);
        }
        return -1;
    }


    // Wrong Approach
    public static int ropeCutWrong(int n, int a, int b, int c) {
        if( n <= 0 ) return 0;
        int max  = 0;
        int cutWith = 0;
        int shortestCut = n;
        if( n % a < shortestCut && n/a > max) {
            max = n/a;
            shortestCut = n%a;
            cutWith = a;
        }
        if( n % b < shortestCut && n/b > max) {
            max = n/b;
            shortestCut = n%b;
            cutWith = b;
        }
        if( n % c < shortestCut && n/c > max) {
            max = n/c;
            shortestCut = n%c;
            cutWith = c;
        }
        return cutWith + ropeCutWrong(n-cutWith, a, b, c);
    }
}
