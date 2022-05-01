package BitMagic;

public class SwapOddEvenBits {
    public static void main(String[] args) {
        System.out.println(swapBits(11));
    }

    public static int swapBits(int n) 
    {
	    // Your code
        int evenMask = 0B10101010101010101010101010101010;
        int oddMask =  0B01010101010101010101010101010101;
        return ( ((evenMask&n)>>1) | ((oddMask&n)<<1)  );
	}
}
