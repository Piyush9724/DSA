package Arrays;

import java.util.Scanner;

public class ArrayOperations {

    public static int arr[];
    public static int capacity;

    public static String createArray(int n){
        arr = new int[n];
        capacity = n;
        return "Array Created initial capcity is " + n;
    }

    public static String insertElementAtBegining(int position, int element){
        if(capacity == 0) return "Capacity Full";
        if(position > arr.length) return "Invalid position";
        int index = position -1;
        for(int i=arr.length-2;i>=index;i--){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        capacity--;
        return "Element inserted at position " + position;
    }

    public static String insertElementAtEnd(int position, int element){
        if(capacity == 0) return "Capacity Full";
        if(position > arr.length) return "Invalid position";
        //int index = position -1;
        arr[arr.length-capacity] = element;
        capacity--;
        return "Element inserted at position " + position;
    }

    public static String getElement(int position){
        if(position <= arr.length)
            return arr[position-1]+"";
        else return "Position is greater than the capacity";
    }

    public static int binarySearch(int l, int r, int x){
        if( r < l){
            return -1;
        }
        int mid = Math.floorDiv(l+r, 2);
        if( arr[mid]  == x) return mid;
        if(arr[mid] > x ) return binarySearch(l, mid-1, x);
        else return binarySearch(mid+1, r, x);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice1 = 1;
        while( choice1 != 9) {
            System.out.println("Array Operations");
            System.out.println("0. Create");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Linar Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Get");
            System.out.println("7. View Array");
            System.out.println("9. Exit");
            choice1  = sc.nextInt();
            switch(choice1) {
                case 0:{
                    System.out.println("Enter the size of array");
                    System.out.println(createArray(sc.nextInt())+"\n");
                }
                break;
                case 1: {
                    int choice2 = 1;
                    while(choice2 != 9){
                        System.out.println("1. Insert at Begining");
                        System.out.println("2. Insert at the End");
                        System.out.println("3. Custom Insert");
                        System.out.println("9. Back to main menu");
                        choice2 = sc.nextInt();
                        switch(choice2) {
                            case 1: {
                                System.out.println("Enter the element");
                                System.out.println(insertElementAtBegining(1, sc.nextInt()));
                             }
                                break;
                            case 2: {
                                System.out.println("Enter the element");
                                System.out.println(insertElementAtEnd(1, sc.nextInt()));
                             }
                                break;
                            case 3:{
                                System.out.println("Enter position and element");
                                System.out.println(insertElementAtBegining(sc.nextInt(), sc.nextInt()));
                            }
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Enter a valid choice from menu");
                                break;
                        }
                    }
                } break;
                case 2: {
                    int choice2 = 1;
                    while(choice2 != 9){
                        System.out.println("1. Delete at Begining");
                        System.out.println("2. Delete at the End");
                        System.out.println("3. Custom Delete");
                        System.out.println("9. Back to main menu");
                        choice2 = sc.nextInt();
                        switch(choice2) {
                            case 1: 
                                break;
                            case 2: 
                                break;
                            case 3:
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Enter a valid choice from menu");
                                break;
                        }
                    }
                } break;
                case 3: 
                     break;
                case 4: 
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Enter the position of element to get");
                    System.out.println(getElement(sc.nextInt()));
                    break;
                case 7:{
                   for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
                    }
                    break;
                case 9:
                    sc.close();
                    break;
                default:
                    System.out.println("Enter a valid choice from menu");
                    break;
            }
        }
    }


}
