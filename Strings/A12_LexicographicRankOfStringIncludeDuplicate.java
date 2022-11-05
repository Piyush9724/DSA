
public class A12_LexicographicRankOfStringIncludeDuplicate {

    public static void main(String[] args) {
        System.out.println(findRank("bbbcccaaa"));
    }
    static int fact(int n){
        return (n<=1)? 1 : n * fact(n-1);
    }
    
    static int countSmallInRight(String str, int l, int h){
        int count = 0,i;
        for( i= l+1;i<=h;++i){
            if(str.charAt(i) <= str.charAt(l))
                count++;
        }
        return count;
    }
    static int findRank(String str){
        // code here
        int len = str.length();
        int fact = fact(len);
        int rank = 1;
        int countInRight;
        int count[] =  new int[256];

        for(int i=0;i<len;i++){
            count[str.charAt(i)]++;
        }
        for(int i=0;i<len;i++){
            fact /= len-i;
            countInRight = countSmallInRight(str,i, len-1);
            rank += countInRight * fact;                
        }
        
        for(int i=0;i<len;i++){
            if(count[str.charAt(i)]>1){
                 rank  = rank/fact(count[str.charAt(i)]);
                 count[str.charAt(i)] = 1; 
            }
        } 
        
        return rank%1000003;
    }
}
