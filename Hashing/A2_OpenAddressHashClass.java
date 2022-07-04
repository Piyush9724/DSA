package Hashing;

import java.util.Scanner;

public class A2_OpenAddressHashClass {
    public static void main(String[] args) {
        int choice=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Open Address Hashing implementation");
        System.out.println("Enter Hash Table Size");
        OpenHash hs = new OpenHash(sc.nextInt());
        while(choice != 9){
            System.out.println("Open Address Hashing implementation");
            System.out.println("1.Display");
            System.out.println("2.Insert");
            System.out.println("3.Remove");
            System.out.println("4.Search");
            System.out.println("5.Size");
            System.out.println("6.isEmpty");
            System.out.println("7.Clear");
            System.out.println("9.Exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    hs.displayHash();
                    break;
                case 2:
                    System.out.println("Enter key to insert");
                    hs.insert(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter key to remove");
                    hs.remove(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter key to search");
                    System.out.println( hs.search(sc.nextInt())?"Present":"Not Presesnt");
                    break;
                case 5:
                    System.out.println(hs.size());
                    break;
                case 6:
                    System.out.println(hs.isEmpty());
                    break;
                case 7: 
                    hs.clear();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
        }
        sc.close();  
    }
}

class OpenHash{
    int BUCKET;
    int curSize = 0;
    int[] table;
    OpenHash(int b){
        BUCKET = b;
        table = new int[b];
        for(int i=0;i<b;i++)
             table[i] = -1;
    }

    public int hash1(int key){
        return key%BUCKET;
    }

    public int hash2(int key){
        int a = BUCKET -1;
        return a - ( key % a);
    }

    public boolean insert(int key){
        if(curSize == BUCKET) {
            System.out.println("TABLE FULL");
            return false;
        }
        if( !search(key)){
            int probe =hash1(key);
            int offset = hash2(key);
            while(table[probe] > -1){
                probe  = (probe + offset) % BUCKET;
            }
            table[probe] =  key;
            curSize++;
            return true;
        }else{
            return false;
        }
    }

    public boolean remove(int key){
        if(curSize == 0){
            System.out.println("TABLE EMPTY");
            return false;
        }
        int probe = hash1(key);
        int offset = hash2(key);
        while(table[probe] != -1 || table[probe] != -2){
            if(table[probe] == key){
                table[probe] = -2;
                curSize--;
                return true;
            }
            probe = (probe + offset) % BUCKET;
        }
        System.out.println("KEY NOT PRESENT");
        return false;
    }

    public boolean search(int key){
        int probe = hash1(key);
        int offset = hash2(key);
        while(table[probe]!=-1){
            if(table[probe] == key)
                return true;
            probe = (probe + offset) % BUCKET;
        }
        return false;
    }

    public void displayHash(){
        System.out.print("|");
        for(int i=0;i<BUCKET;i++){
            System.out.print(table[i]+"|");
        }
    }

    public int size(){
        return curSize;
    }

    public boolean isEmpty(){
        if(curSize == 0) return true;
        else return false;
    }

    public void clear(){
        for(int i=0;i<BUCKET;i++){
            table[i] = -1;
        }
    }
}