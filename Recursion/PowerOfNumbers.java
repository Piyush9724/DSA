package Recursion;

public class PowerOfNumbers {
    public static void main(String[] args) {
        System.out.println(power(12,21));
        System.out.println(powerOptimal(12, 21));
    }

    //Not Optimal
    static long power(int N,int R)
    {
        //Your code here
        if(R == 0) return 1;
        else return ( N * ( power(N, R-1) ))% 1000000007 ;
        
    }

    static  long powerOptimal(int N,int R)
    {
        //Your code here
        // if(R == 0) return 1;
        // else return ( N * ( power(N, R-1) ))% 1000000007 ;
        
        int m = 1000000007;
        
        if(N==1 || R <= 1)
            return N;
            
        long temp = powerOptimal(N,R/2);
            
        if( R%2 ==0)
            return temp%m*temp%m;
            
        else
            return N * temp%m * temp%m;
        
    }
}
