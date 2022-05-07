package Recursion;


public class GenerateSubsets {
    public static void main(String[] args) {
      printSubSets("ABC","",0);
      printCombinations("abc", "");
    }

    public static void printSubSets(String s, String cur, int i){
        if( s.length() == i){
            System.out.print("\'"+cur+"\'"+" ");
            return;
        }
        printSubSets(s, cur, i+1);
        printSubSets(s, cur+s.charAt(i), i+1);
    }

    public static void printCombinations(String initial, String combined) {
        System.out.print(combined + " ");
        for (int i = 0; i < initial.length(); i++) {
            printCombinations(initial.substring(i + 1),
                    combined + initial.charAt(i));
    
        }
    }


}
