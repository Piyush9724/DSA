package BitMagic;

public class CountSetBits {
    public static void main(String[] args) {
       System.out.println( countSetBits(15));
       System.out.println(countSetBitsBrianKerningamsAlgorithm(15));
       System.out.println(countSetBitsLookupTable(15));
    }

    //naive approach  O(logn bits in N)
    public static int countSetBits(int n) {
       // System.out.println((int) (Math.log(n) / Math.log(2)));
        int count = 0;
        for(int i=0;i<=(int) (Math.log(n) / Math.log(2));i++) {
            if( ( (n>>i) & 1 ) != 0) count++;
        }
        return count;
    }

    //BrianKerningamsAlgorithm O ( Set Bits in N)
    public static int countSetBitsBrianKerningamsAlgorithm(int n) {
        int res = 0;
        while( n > 0 ) {
            n = (n & ( n -1 ));
            res++;
        }
        return res;
    }


    // Lookup Table Approach O(1)
    static int table[] = new int[256];
    static void initialize() {
        table[0] =  0;
        for(int i = 1; i < 256; i++)
            table[i] = ( i & 1) + table[i/2];
    } 

    public static int countSetBitsLookupTable(int n) {
        initialize();
        int res = table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        n = n >> 8;
        res += table[n & 0xff];
        n = n >> 8;
        return res;

    }


}
