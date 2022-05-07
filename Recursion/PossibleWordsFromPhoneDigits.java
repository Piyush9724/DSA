package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleWordsFromPhoneDigits {
    static String[] keypad = {"","a b c","d e f","g h i","j k l","m n o","p q r s","t u v","w x y z"};
    public static void main(String[] args) {
        // System.out.println(generateWords("a b c", "d e f"));
        // System.out.println(generateWords(generateWords("a b c", "d e f"), "g h i"));
        int a[] = {2,3,4};
        System.out.println(possibleWords(a, 3));
    }
    static ArrayList <String> possibleWords(int a[], int N)
    {
        ArrayList<String> apw = new ArrayList<>();
        for(int i=0;i<a.length;i++) apw.add(keypad[a[i]-1]);
        String res = "";
        if( apw.size() >1){
          res = possibleWordsRec(apw);
        }
        else{
            res = keypad[a[0]-1];
        }
        apw.clear();
        apw.addAll(Arrays.asList(res.split("\\s+")));
        return apw;
    }

    static String possibleWordsRec(List<String> a){
        String res = "";
        if( a.size() == 2){
            res =  generateWords(a.get(0), a.get(1));
            return res;
        }
        return generateWords(a.get(0), possibleWordsRec(a.subList(1, a.size())));
    }

    static String generateWords(String s,String r){
        ArrayList<String> ss = new ArrayList<>(Arrays.asList(s.split("\\s+")));
        ArrayList<String> rr = new ArrayList<>(Arrays.asList(r.split("\\s+")));
        String g = "";
        for(int i=0;i<ss.size();i++){
            for(int j=0;j<rr.size();j++){
               g+=(ss.get(i)+rr.get(j))+ ' ';
            }
        }
        return g.trim();
    }
}
