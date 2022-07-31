import java.util.*;
public class A2_CheckForSubsequence 
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String a = sc.next();
            String b = sc.next();
            CheckForSubsequenceSolution ob = new CheckForSubsequenceSolution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        }
        sc.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class CheckForSubsequenceSolution{
    boolean isSubSequence(String A, String B){
        int i = 0,j=0;
        while(i<A.length() && j<B.length()){
            if(A.charAt(i) == B.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if( i == A.length())
            return true;
        else
            return false;
    }
}