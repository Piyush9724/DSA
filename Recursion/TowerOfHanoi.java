package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(2, 'A', 'B', 'C');
    }

    //Optimal Approach 
    public static void towerOfHanoi(int n,char a, char b, char c){
        if( n == 0) return;
        towerOfHanoi(n-1, a, c, b);
        System.out.println("Move disc "+n+" from "+a+" -> "+c);
        towerOfHanoi(n-1, b, a, c);
    }
}
