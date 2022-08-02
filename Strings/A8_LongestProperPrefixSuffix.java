import java.io.*;
import java.util.*;

public class A8_LongestProperPrefixSuffix {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            LongestProperPrefixSuffix ob = new LongestProperPrefixSuffix();
            System.out.println(ob.lpsinKMP(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class LongestProperPrefixSuffix {
    List<Integer> lpsMyApproach(String s) {
        int i=0;
        Set<String> prefix = new HashSet<>();
        Set<String> suffix = new HashSet<>();
        
        List<Integer> lpsList = new ArrayList<>();
        while(i<s.length()){
            int longestlps = 0;
            String pfx ="", sfx= "";
            int j = 0;
            while(j<=i){
               if(j != i){
                    pfx += s.charAt(j);
                    prefix.add(pfx);
               }
               sfx = s.charAt(i-j)+sfx;
               suffix.add(sfx);
               if(suffix.contains(pfx))
                    longestlps = Math.max(pfx.length(), longestlps);
               j++;
            }
            lpsList.add(longestlps);
            prefix.clear();
            suffix.clear();
            i++;
        }
        return lpsList;
    }

    List<Integer> lpsinKMP(String s){
        int n = s.length();
        int len = 0;
        Integer lps[] = new Integer[n];
        lps[0] = 0;
        int i = 1;
        while(i<n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
       List<Integer> lpsArray = Arrays.asList(lps);
       return  lpsArray;
    }
}

/*
1
ababc
 */