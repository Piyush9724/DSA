import java.io.*;

class A11_CountOccurencesOfAnagrams {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new A11_CountOccurencesOfAnagramsSolution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class A11_CountOccurencesOfAnagramsSolution {
    
    int search(String pat, String text) {
        // code here
        int n  = text.length();
        int m = pat.length();
        int count = 0;

        int p = (int)pat.charAt(0)-96, t = (int)text.charAt(0)-96;
        for(int i=1;i<m;i++){
            p+= pat.charAt(i)-96;
            t+= text.charAt(i)-96;
        }

        for(int i = 0; i <= (n-m); i++){
            //Check for Hit
               // System.out.println("p: "+p+"t: "+t);
            if(p == t){
                if(isAnagram(text.substring(i,i+m), pat))
                    count++;
            }

            //Computer Rolling Hash
            if(i < n-m){
                t -= (int) text.charAt(i)-96;
                t += (int) text.charAt(i+m)-96;
            }
        }
        return count;
    }
    
    
    static final int CHAR = 256;
    public static boolean isAnagram(String a, String b){
        if(a.length() != b.length()) return false;
        int count[] = new int[CHAR];
        for(int i=0;i<a.length();i++){
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }

        for(int i=0;i<CHAR;i++)
            if(count[i] != 0 ) return false;
        
        return true;
    }
}