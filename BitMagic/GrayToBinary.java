package BitMagic;

public class GrayToBinary {
    public static void main(String[] args) {
        System.out.println(grayToBinary(10));
    }
    public static int grayToBinary(int n) {
        
        // Your code here
        int res= 0;
        while(n>0) {
            res ^= n;
            n >>= 1;
        }
        return res;
    }
}
