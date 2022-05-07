package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
       // System.out.println("a".substring(1));
       System.out.println(subsets("abc"));
    }


    //My Approach
    public static List<String>  subsets(String s) {
        List<String> allSubsets =  new ArrayList<>();
        if(s.length() == 0){
            allSubsets.add(s);
            return allSubsets;
        } 
        String first = s.charAt(0)+"";

        List<String> rest = subsets(s.substring(1));
        allSubsets.addAll(rest);
        for (String subsetWithoutFirst : rest) {
            allSubsets.add(first+subsetWithoutFirst);
        }
        return allSubsets;    
    }


    //Another Approach
    static void powerSetUtil(String str, ArrayList<String> v,int index,String curr)
    {
        int n = str.length();
        
        // base case
        if (index == n)
        {
           v.add(curr);    
           return;
        }   
        //Two cases for every character
        //(i) We consider the character as part of current subset.
        //(ii) We do not consider current character as part of current subset.
        
        //Calling the function recursively for both cases.
        powerSetUtil(str, v, index+1, curr);
        powerSetUtil(str, v, index+1, curr+str.charAt(index));
    }

}
