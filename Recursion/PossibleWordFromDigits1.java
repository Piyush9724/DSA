package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class PossibleWordFromDigits1 {
     //Function to find list of all words possible by pressing given numbers.
     public static void main(String[] args) {
        int number[] = {2, 3, 4};
        ArrayList<String> stringList =  possibleWords(number, 3);
        System.out.println(stringList);
     }
     static Map<Integer,String> keypad =  Map.of(
         0,"",
         1,"",
         2,"abc",
         3,"def",
         4,"ghi",
         5,"jkl",
         6,"mno",
         7,"pqrs",
         8,"tuv",
         9,"wxyz"
     );
     static ArrayList <String> possibleWords(int a[], int N)
     {
         // your code here  
         ArrayList<String> stringList = generateWords(a, N, 0, "");
         return stringList;
     }

     static ArrayList<String> generateWords(int[] numbers, int len, int numIndex, String s){
         if( len == numIndex ){
             return new ArrayList<>(Collections.singleton(s));
         }
         ArrayList<String> stringList = new ArrayList<>();
         for( int i=0;i < keypad.get(numbers[numIndex]).length() ; i++ ){
             String sCopy = s;
             sCopy = sCopy.concat( keypad.get(numbers[numIndex]).charAt(i)+"");
             stringList.addAll(generateWords(numbers, len, numIndex+1, sCopy));
         }
         return stringList;
     }

     
}
