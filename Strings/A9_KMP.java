import java.io.*;
import java.util.*;

public class A9_KMP 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            KMP ob = new KMP();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
        sc.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class KMP
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> result =  new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        int lps[] = new int[m];
        lps = fillLPS(pat, lps);
        int i = 0, j=0;
        while(i<n){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if( j == m){
                //System.out.print("At : " + (i-j) +" ");
                result.add(i-j+1);
                j = lps[j-1];
            }else if(i < n && pat.charAt(j) != txt.charAt(i)){
                if(j == 0)
                    i++;
                else    
                    j = lps[j-1];
            }
        }
        return result;
    }

    int[] fillLPS(String pat, int[] lps){
        int n = pat.length();
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i<n){
            if(pat.charAt(i) == pat.charAt(len)){
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
        return lps;
    }
}

