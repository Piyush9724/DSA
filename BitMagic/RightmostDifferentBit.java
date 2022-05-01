package BitMagic;

public class RightmostDifferentBit {
    public static void main(String[] args) {
        System.out.println(posOfRightMostDiffBit(11, 19));
    }

    //First approach
    public static int posOfRightMostDiffBit(int m, int n)
    {
        n = (m ^ n);
        for (int i=0;i<=(int) (Math.log(n) / Math.log(2));i++){
            if( (n & (1<<i)) != 0) return i+1;
        }
        return -1;
            
    }


    //Second Appraoch
    public static int posOfRightMostDiffBitOptimal(int m, int n)
    {
        if( n==m) return -1;
        n = (m ^ n);
        return (int)(Math.log(n&-n)/Math.log(2.0)) + 1;
    }



}
