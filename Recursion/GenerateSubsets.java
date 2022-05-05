package Recursion;


public class GenerateSubsets {
    public static void main(String[] args) {
      printSubSets("ABC","",0);
    }

    public static void printSubSets(String s, String cur, int i){
        if( s.length() == i){
            System.out.print("\'"+cur+"\'"+" ");
            return;
        }
        printSubSets(s, cur, i+1);
        printSubSets(s, cur+s.charAt(i), i+1);
    }


}
