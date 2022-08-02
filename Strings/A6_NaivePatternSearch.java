import java.io.*;

public class A6_NaivePatternSearch {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            String text = input[0];
            String pattern = input[1];
            NaivePatternSearchSolution ob = new NaivePatternSearchSolution();
            System.out.println("Count : "+ ob.search(text,pattern));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class NaivePatternSearchSolution {
    int search(String text, String pat) {
        // code here
        int count = 0;
        int m = pat.length();
        int n = text.length();
        for(int i=0;i<=n-m;i++){
            int j;
            for(j = 0;j<m;j++)
                if(pat.charAt(j) != text.charAt(i+j))
                    break;
            if(j == m){
                count++;
                System.out.print("At : "+i+" ");
            }
        }
        return count; 
    }

    int optimisedSearch(String text, String pat){
        int count = 0;
        int m = pat.length();
        int n = text.length();
        for(int i=0;i<=n-m; ){
            int j;
            for(j = 0;j<m;j++)
                if(pat.charAt(j) != text.charAt(i+j))
                    break;
            if(j == m){
                System.out.print("At :"+i+" ");
                count++;
            }
            if(j == 0)
                i++;
            else
                i = (i + j);
        }
        return count;
    }
};


/*
1
ABCABCDABCD ABCD
 */