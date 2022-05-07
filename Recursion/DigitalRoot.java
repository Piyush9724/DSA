package Recursion;

public class DigitalRoot {
    public static void main(String[] args) {
        System.out.println(digitalRoot(56));
    }

    public static int digitalRoot(int n)
    {
        // add your code here
        if( n < 10) {
            return n;
        }else{
            return digitalRoot(n%10 +  digitalRoot (n/10));
        }
    }
}
