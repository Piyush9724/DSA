package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;

public class JosephusProblem {
    public static void main(String[] args) {
        initiateJosephusProblem(7, 3);
        System.out.println(josephusProblem(7, 3));
    }
    //My Approach Caller
    public static void initiateJosephusProblem(int n, int k) {
        List<Integer> p = new ArrayList<>((Arrays.stream(IntStream.range(0, n).toArray())).boxed()
                .collect(Collectors.toList()));
        p = kill(p, 0, k);
        System.out.println("Survivor :: " + p);
    }

    //My Approach kill recursive  TC ::  O(N)  SC :: O(N)
    public static List<Integer> kill(List<Integer> p, int n, int k) {
        if (p.size() == 1)
            return p;
        int indexToKill = n + k - 1;
        if (indexToKill >= p.size())
            indexToKill %= p.size();
        p.remove(indexToKill);
        n = indexToKill;
        System.out.println(p);
        p = kill(p, n, k);
        return p;
    }

    // Optimal Approach TC ::  O(n)  SC :: O(1)
    public static int josephusProblem(int n, int k){
        if( n == 1) return 0;
        else return (josephusProblem(n-1, k)+k)%n;
    }

}
