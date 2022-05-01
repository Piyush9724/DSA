package BitMagic;

public class CountTotalSetBitsIn1toN {
    public static void main(String[] args) {
        for(int i = 1;i< 100000;i++)
            if( countSetBits(i) != countSetBitsIn1toN(i)) System.out.println(i);
       // System.out.println(countSetBitsIn1toN(4));
    }

    //initial approach O(nlogn)
    public static int countSetBits(int n){
    
        // Your code here
        int res=0;
        while(n>0){
            int m = n;
            while(m>0){
                m = ( m & (m-1) );
                res++;
            } 
            n--;
        }
        return res;
    }

    //Optimal approach O(logn)
    public static int countSetBitsIn1toN(int n) {
        if(n==2) return 2;
        if(n==1) return 1;
        if(n == 0 ) return 0;
        int x= 0;
        while( (1<<x) <=n ){
            x++;
        }
        int setBitUptoX  = (1 << (x-2))*(x-1);
        int remainingNo =  n-(1<<(x-1))+1;
        int setBitRest = countSetBitsIn1toN(remainingNo-1);
        return setBitUptoX+setBitRest+remainingNo;
    }


    
}
