import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A7_RabinKarpAlgo {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            String text = input[0];
            String pattern = input[1];
            RabinKarpSearch ob = new RabinKarpSearch();
            System.out.println("Count : "+ ob.search(text,pattern));
        }
    }
}

class RabinKarpSearch {
    static final int q = 101;
    static final int d = 256;
    int search(String text, String pat) {
        int n  = text.length();
        int m = pat.length();
        int count = 0;

        //Compute d^(m-1)
        int h = 1;
        for(int i=1; i <= m-1; i++){
            h = (h*d) %q;
        }

        //Computer p and t0
        int p = 0, t = 0;
        for(int i=0;i<m;i++){
            p = (p*d + pat.charAt(i)) % q;
            t = (t*d + text.charAt(i)) % q;
        }

        for(int i = 0; i <= (n-m); i++){
            //Check for Hit
            if(p == t){
                boolean flag = true;
                for(int j=0;j<m;j++){
                    if(text.charAt(i+j) != pat.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    System.out.print("At : "+i+" ");
                    count++;
                }
            }

            //Computer Rolling Hash
            if(i < n-m){
                t = ( (d * (t - (text.charAt(i) *h))) + text.charAt(i+m) ) % q;
                if(t < 0)
                    t = t + q;
            }
        }
        return count;
    }
}


/*
1
abdabcbabc abc
 */