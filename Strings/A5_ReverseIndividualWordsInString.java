import java.util.*;

public class A5_ReverseIndividualWordsInString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            ReverseIndividualWordsInStringSolution obj = new ReverseIndividualWordsInStringSolution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
        sc.close();
    }
}

// } Driver Code Ends

class ReverseIndividualWordsInStringSolution {
    // Function to reverse words in a given string.
    String reverseWords(String S) {
        // code here
        String result = "";
        int start, end = S.length();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '.') {
                start = i + 1;
                result += S.substring(start, end);
                result += '.';
                end = i;
            }
        }
        result += S.substring(0, end);

        return result;
    }
}
