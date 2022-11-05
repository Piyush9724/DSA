import java.io.*;

public class A12_LexicographicRankOfString {
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
           // A12_LexicographicRankOfStringSolutionN2 ob = new A12_LexicographicRankOfStringSolutionN2();
            System.out.println(A12_LexicographicRankOfStringSolutionN.rank(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class A12_LexicographicRankOfStringSolutionN {
    static int fact(int n){
        return ( n<=1 )? 1 : n*fact(n-1);
    }

    static int CHAR = 256;

    static int rank(String str){
        int len = str.length();
        int fact = fact(len);
        int rank =1,i;
        int count[] =  new int[CHAR];
        for(i=0;i<len;i++)
            count[str.charAt(i)]++;
        for(i = 1;i<CHAR;i++)
            count[i] += count[i-1];

        for(i=0;i<len;i++){
            fact /= len -i;
            rank = rank + count[str.charAt(i)-1] * fact;
            for(int j = str.charAt(i);j<CHAR;j++)
                count[j]--;
        }

        return rank;
    }

}

class A12_LexicographicRankOfStringSolutionN2{
    
    static int fact(int n){
        return (n<=1)? 1 : n * fact(n-1);
    }
    
    static int countSmallInRight(String str, int l, int h){
        int count = 0,i;
        for( i= l+1;i<=h;++i){
            if(str.charAt(i) < str.charAt(l))
                count++;
            if(str.charAt(i) == str.charAt(l))
                return -1;
        }
        return count;
    }
    static int rank(String str){
        // code here
        int len = str.length();
        int fact = fact(len);
        int rank = 1;
        int countInRight;
        
        for(int i=0;i<len;i++){
            fact /= len-i;
            countInRight = countSmallInRight(str,i, len-1);
            if(countInRight == -1) return 0;
            rank += countInRight * fact;
        }
        
        return rank%1000003;
    }
}

