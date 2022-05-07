package Recursion;

public class LuckyNumber {
    public static void main(String[] args) {
        System.out.println(lucky(19,2));
    }


    public static boolean lucky(int n, int c){
        if(n < c ) return true;
        if(n%c == 0) return false;
        return lucky(n-(n/c), c+1);
    }
}
