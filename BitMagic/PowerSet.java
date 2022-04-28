package BitMagic;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }

    public static List<String> powerSet(String s){
        List<String> res = new ArrayList<>();
        int n = s.length();
        int powSize = (int)Math.pow(2, n);
        for(int counter =0 ;counter<powSize;counter++){
            String r = "";
            for(int j=0;j<n;j++) {
                if((counter & (1<<j)) != 0) {
                    r = r + s.charAt(j);
                }
            }
            res.add(r);
        }
        return res;
    }
}
