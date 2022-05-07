package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
       // towerOfHanoi(2, 'A', 'B', 'C');
        //towerOfHanoiCount(2, 'A', 'B', 'C');
        System.out.println(towerOfHanoiCount(3, 'A', 'B', 'C'));
    }

    //Optimal Approach 
    public static void towerOfHanoi(int n,char a, char b, char c){
        if( n == 0) return;
        towerOfHanoi(n-1, a, c, b);
        System.out.println("Move disc "+n+" from "+a+" -> "+c);
        towerOfHanoi(n-1, b, a, c);
    }

    public static long towerOfHanoiCount(int n,char a, char b, char c){
        int res = 0;
        if( n == 0) return 0;
        res+=towerOfHanoiCount(n-1, a, c, b);
        res++;
        System.out.println("Move disc "+n+" from "+a+" -> "+c);
        res+=towerOfHanoiCount(n-1, b, a, c);
        return res;
    }
}
