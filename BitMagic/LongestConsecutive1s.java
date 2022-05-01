package BitMagic;

public class LongestConsecutive1s {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(11));
        System.out.println(maxConsecutiveOnesOptimal(11));
    }
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    // My Approach O(logn)
    public static int maxConsecutiveOnes(int N) {
        int maxSeqCount=0;
        int seqCount = 0;
        int count = 0;
        // Your code here
        for(int i=0;i<=(int) (Math.log(N) / Math.log(2));i++) {
            if( ( (N>>i) & 1 ) !=0 ) {
                count++;
                if( ( (N>>i+1) & 1 ) ==0 ){
                    seqCount = count;
                    count=0;
                }
            }
            if( seqCount > maxSeqCount) maxSeqCount= seqCount;
        }
        return maxSeqCount;
    }
    
    // Optimal Approach O(logn)
    public static int maxConsecutiveOnesOptimal(int N) {
        int count = 0;
        
        //We use a loop to perform AND operation on N and N<<1 and everytime
        //the trailing 1 from every sequence of consecutive 1s is removed.
        //Loop continues till N is reduced to 0.
        while (N!=0) {
            //Assigning result of AND operation to N
            N = (N & (N << 1));
            //increement of counter variable.
            count++;
        }
        //returning the answer.
        return count;
    }
}
