package Recursion;

public class Permutations {
    public static void main(String[] args) {
        permutations("ABC", 0);
        //System.out.println( swap("ABCD", 0, 1));
    }

    public static void permutations(String s,int i){
        if ( i == s.length()-1 ) {
            System.out.println(s);
            return;
        }
        for(int j =i;j<s.length();j++ ){
            s =  swap(s,i,j);
            permutations(s, i+1);
            s =  swap(s,i,j);
        }
    }

    public static String swap(String s,int i,int j){
       char[] res = s.toCharArray();
       char temp = res[i];
       res[i] =  res[j];
       res[j] = temp;
       s = String.copyValueOf(res);
       return s;
    }
}
