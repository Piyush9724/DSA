package BitMagic;

public class FindFirstSetBitFromRight {
    public static void main(String[] args) {
        System.out.println(findFirstSetBitFromRight(4));
        System.out.println(findFirstSetBitFromRightOptimal(4));
    }

    //First approach 
    public static int findFirstSetBitFromRight(int n) {
        for (int i=0;i<=(int) (Math.log(n) / Math.log(2));i++){
            if( (n & (1<<i)) != 0) return i+1;
        }
        return 0;
    }

    //Optimal Approach
    public static int findFirstSetBitFromRightOptimal(int n) {
        if(n==0)
        return 0;
        
        //doing AND operation of n and -n. n and -n will have similar
        //bits only till the first set bit starting from the right  
        //and differnt bits after the first set bit.Then we take 
        //log2 of the result to find the position.
        
        //we add 1 to obtained value so that count starts from 1 instead of 0.
        
        return (int)(Math.log(n&-n)/Math.log(2.0)) + 1;
    }
}

