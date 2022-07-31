import java.io.*;

public class A1_PalindromeCheck {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            PalindromeCheck ob = new PalindromeCheck();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class PalindromeCheck {
    int isPalindrome(String S) {
        // code here
        int l = 0, r = S.length()-1;
	    while(r>l){
	        if(S.charAt(l++) != S.charAt(r--))
	            return 0;
	    }
	    return 1;
    }
};