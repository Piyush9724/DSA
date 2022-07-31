import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class A3_CheckForAnagrams {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            if (CheckForAnagramsSolution.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
// } Driver Code Ends

class CheckForAnagramsSolution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<a.length();i++)
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0)+1);
        for(int i=0;i<b.length();i++){
            if(map.containsKey(b.charAt(i))){
                map.put(b.charAt(i), map.get(b.charAt(i))-1);
                if(map.get(b.charAt(i)) == 0)
                    map.remove(b.charAt(i));
            }else{
                return false;
            }
        }
        if(map.size() > 0) return false;
         return true;
    }
    
    static final int CHAR = 256;
    public static boolean isAnagramOptimal(String a, String b){
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