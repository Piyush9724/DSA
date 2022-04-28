package BitMagic;

import java.util.ArrayList;
import java.util.List;

public class TwoOddOccuring {
    public static void main(String[] args) {
        int a[] = {3,4,3,4,5,4,4,6,7,7};
        System.out.println(checkTwoOddOccuring(a));
    }

    public static List<Integer> checkTwoOddOccuring(int[] a) {
        List<Integer> res =  new ArrayList<>();
        int xor = 0, res1=0, res2=0;
        for( int i=0;i<a.length;i++) {
            xor = xor ^ a[i];
        }
        int rightMostSetBitNumber = xor & ~(xor-1);
        for(int i=0;i<a.length;i++){
            if ( (a[i] & rightMostSetBitNumber) != 0) 
                res1 = res1 ^ a[i];
            else
                res2 = res2 ^ a[i];
        }
        res.add(res1);
        res.add(res2);
        return res;
    }
}
