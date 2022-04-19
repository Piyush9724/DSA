package Maths;

public class PalindromeNumber {
   public static void main(String[] args) {
       System.out.println(isPalindrome(11));
   } 

   public static boolean isPalindrome(int n) {
       if ( n < 10 ) return true;
       int org = n;
       int rev = 0; // reversed number
       int rem;   // remainder
       while(n>0){
        rem = n%10;
        rev = (rev*10) + rem;
        n = n/10;
      }
      if( rev == org ) return true;
      else return false;
   }
}
