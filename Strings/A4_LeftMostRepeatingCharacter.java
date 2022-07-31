import java.io.*;
import java.util.*;

public class A4_LeftMostRepeatingCharacter 
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            LeftMostRepeatingCharacterSolution ob = new LeftMostRepeatingCharacterSolution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
        sc.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class LeftMostRepeatingCharacterSolution
{
    char firstRep(String S)
    {
        // your code here
        int count[] = new int[26];
        char result = '#';
        for(int i=0;i<S.length();i++){
            count[S.charAt(i)-'a']++;
            if(count[S.charAt(i)-'a'] >1){
                if(result == '#') result = S.charAt(i);
                else if(S.indexOf(result) > S.indexOf(S.charAt(i)))
                        result = S.charAt(i);
            }
        }
        return result;
    }

    char firstRepOptimal(String S)
    {
        // your code here
        int count[] = new int[26];
        for(int i=0;i<S.length();i++)
            count[S.charAt(i)-'a']++;
        for(int i=0;i<S.length();i++){
            if(count[S.charAt(i)-'a'] >1){
                return S.charAt(i);
            }
        }
        return '#';
    }


}

