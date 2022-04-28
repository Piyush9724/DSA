package BitMagic;

public class CheckKthBit {
    public static void main(String[] args) {
        System.out.println(checkKthBit(5, 3));
    }

    public static boolean checkKthBit(int n, int k) {
        if( (n & (1<<(k-1))) != 0 ) return true;
        return false;
    }
}
