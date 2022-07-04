package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class A1_ChainingHashClass {
    public static void main(String[] args) {
        ChainHash hs = new ChainHash(5);
        hs.insertKey(7);
        //hs.remove(7);
        System.out.println(hs.search(7));
    }
}


class ChainHash {
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;
    ChainHash(int b){
        BUCKET = b;
        table = new ArrayList<>();
        for(int i=0;i<b;i++){
            table.add(new LinkedList<Integer>());
        }
    }

    public void insertKey(int key){
        table.get(hash(key)).add(key);
    }

    public void remove(int key){
        // if(table.get(hash(key)).indexOf(key) > -1)
        //     table.get(hash(key)).remove(table.get(hash(key)).indexOf(key));
        table.get(hash(key)).remove((Integer) key);//optimised
    }

    public boolean search(int key){
    //    if(table  != null &&
    //       table.get(hash(key)).stream().filter( k -> k == key).findAny().orElse(null) != null){
    //         return true;
    //    }else return false;
          return table.get(hash(key)).contains(key); //optimised
    }

    private int hash(int key){
        return key%BUCKET;
    }
}