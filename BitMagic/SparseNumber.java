package BitMagic;

public class SparseNumber {
    public static void main(String[] args) {
        //System.out.println((int) (Math.log(6)/Math.log(2)));
        System.out.println(isSparse(5));
        System.out.println(isSparseOptimal(10));
    }

    //First Approach O(logn)
    public static boolean isSparse(int n)
    {
        // Your code here
        for(int i=0;i<=(int) (Math.log(n) / Math.log(2));i++) {
            if( ( (n>>i) & 1 ) != 0 && ( (n>>i+1) & 1 ) != 0) return false;
        }
        return true;
    }

     //Optimal Approach
     public static boolean isSparseOptimal(int n)
     {
         // Your code here
         return (n & (n>>1)) == 0;
     }
}


