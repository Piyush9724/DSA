package BitMagic;

import java.util.ArrayList;
import java.util.List;

public class OneOddOccuring {
    public static void main(String[] args) {
        //int a[] = {4,3,4,4,4,5,5};
        int a[] = {4,3,4,4,3,4,5,5,7};
        System.out.println(checkOneOddOccuring(a));
        System.out.println(checkOneOddOccuringEfficient(a));
    }

    //Naive Approach   O( n^2 )
    public static int checkOneOddOccuring(int a[]) {
        if( a.length == 0 ) return 0;
        List<Integer> visited = new ArrayList<>();
        int count = 0;
        for(int i=0;i < a.length;i++) {
            if ( visited.contains(a[i]) ) continue;
            else {
                visited.add(a[i]);
                for(int j = i+1; j<a.length;j++) {
                    if( a[i] == a[j] ) count++;
                }
            }
            if(count%2 ==0 ) return a[i];
            else count =0;
        }
        return 0;
    }


    //Effficient Approach using XOR operator 
    public static int checkOneOddOccuringEfficient(int a[]){
        int res =0;
        for(int i=0;i<a.length;i++) {
              res = a[i]^res;  
        }
        return res;
    }

}
