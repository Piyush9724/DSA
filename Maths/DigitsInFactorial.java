package Maths;

public class DigitsInFactorial {
    public static void main(String[] args) {
        System.out.println(digitsInFactorial(555));
    }

    public static int digitsInFactorial(int N){
        // code here
        double sum = 0;
        
        while(N > 0) {
            sum += Math.log10(N);
            N--;
        }
        
        return (int)(sum + 1); 
    }

   
}
