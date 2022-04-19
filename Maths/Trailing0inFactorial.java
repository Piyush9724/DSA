package Maths;

public class Trailing0inFactorial {
    public static void main(String[] args) {
        System.out.println(numberOfTrailing0(10));
    }

    public static int numberOfTrailing0(int n) {
        int res = 0;
        for (int i = 5; i<=n; i*=5) 
            res += n/i;
        return res;
    }
}
