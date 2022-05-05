package Recursion;

public class PalindromeRecursion {
    public static void main(String[] args) {
        //System.out.println("Piyush".length() /2 );
        System.out.println(palindrome("Piyush", 0));
        System.out.println(palindrome("malayalam", 0));
    }

    public static boolean palindrome(String s, int i){
        if( i > s.length()/2 ) return true;
        if( s.charAt(i) != s.charAt(s.length()-i-1)) 
            return false;
        palindrome(s, i+1);
        return true;
    }
}
