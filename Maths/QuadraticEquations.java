package Maths;
import java.util.*;

public class QuadraticEquations {
    public static void main(String[] args) {
        ArrayList<Integer>  res  = quadraticRoots(752, 906, 164);
        for (Integer x : res) {
            System.out.println(x);
        }
    }

    public static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        // code here
        double determinant = b*b-4*a*c;
        double root1 = 0, root2 = 0;
        ArrayList<Integer> roots = new ArrayList<>();
        System.out.println("Determinant :: "+ determinant);
        if(determinant > 0 ) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        } else if (determinant == 0 ) {
             root1 = root2 = (int) -b / (2 * a);
        } else {
           root1 =  -b / (2 * a);
           root2 =  Math.sqrt(-determinant) / (2 * a);
        }
        if( root1 > root2){
            roots.add((int)( Math.floor(root1)));
            roots.add((int)( Math.floor(root2)));
        } else {
            roots.add((int)( Math.floor(root2)));
            roots.add((int)( Math.floor(root1)));
        }
     System.out.println("root1 :: "+ root1+"root2 :: "+root2);
     return roots;
    }
}