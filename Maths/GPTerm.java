package Maths;

public class GPTerm {
    public static void main(String[] args) {
        //calling method termOfGP() of class GP
		System.out.println((int)Math.floor(termOfGP(2,3,3)));
    }
    public static double termOfGP(int A,int B,int N)
    {
        //Your code here
        if(N == 1) return A * 1.0;
        if(N == 2 ) return B * 1.0;

        double r = (B*1.0)/(A*1.0);
        System.out.println("R :: "+r);
        double res = A* Math.pow(r, N-1);
        System.out.println("Term :: "+ res);
        return res;
    }
}





