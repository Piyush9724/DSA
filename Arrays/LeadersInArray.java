package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = {7,10,4,3,6,5,2};
        System.out.println(leaders(arr, arr.length));
        System.out.println(leadersForLargeInputs(arr, arr.length));
    }

    //My Approach Time limit exceeded because adding new Leaders
    //to front of arraylist takes time for insertion
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> leaders = new ArrayList<>();
        int currLeader  = arr[n-1];
        for(int i = n-1;i>=0;i--){
            if(arr[i] >= currLeader){
                leaders.add(0,arr[i]);
                currLeader = arr[i];
            }
           // System.out.println(leaders);
        }
        return leaders;
    }


    static ArrayList<Integer> leadersForLargeInputs(int arr[], int n){
        // Your code here
        ArrayList<Integer> leaders = new ArrayList<>();
        int currLeader  = arr[n-1];
        for(int i = n-1;i>=0;i--){
            if(arr[i] >= currLeader){
                leaders.add(arr[i]);
                currLeader = arr[i];
            }
           // System.out.println(leaders);
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
