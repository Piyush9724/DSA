package Arrays;

import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
    public static void main(String[] args) {
        //int[] price = {1,5,3,8,12};
        //int[] price = { 100, 180, 260, 310, 40, 535, 695 };
        int[] price = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        //int[] price = {30,20,10};
        //int[] price  = {1,5,3,1,2,8};
        stockBuySellFirst(price, price.length);
    }
    //DSA self preparation Question where pairs needed to be returned
    //My First Apprioach Test cased passed SuccessFully
    ArrayList<ArrayList<Integer> > stockBuySell(int price[], int n) {
        // code here
        ArrayList<ArrayList<Integer> > pairs = new ArrayList<>();
        // code here
        int buyIndex = 0, sellIndex = 0;
        for( int i=1; i<n ; i++) {
            if(price[i]>price[i-1]){
                buyIndex = i-1;
                if(buyIndex+1 < n){
                    sellIndex = buyIndex+1;
                     while(sellIndex<n-1 && price[sellIndex+1]> price[sellIndex]){
                        sellIndex++;
                     }
                     i = sellIndex+1;
                     ArrayList<Integer> pair = new ArrayList<>();
                     pair.add(buyIndex);
                     pair.add(sellIndex);
                     pairs.add(pair);
                     //pairs.add("("+buyIndex+" "+sellIndex+")");
                }
            }
        }
        return pairs;
     }

    //Another Question where pairs needed to be printed
    //My First Approach 176/500 test case passing, Time limit exceeded.
    public static void stockBuySellFirst(int[] price, int n) {
        List<String> pairs = new ArrayList<>();
        // code here
        int buyIndex = 0, sellIndex = 0;
        for( int i=1; i<n ; i++) {
            if(price[i]>price[i-1]){
                buyIndex = i-1;
                if(buyIndex+1 < n){
                    sellIndex = buyIndex+1;
                     while(sellIndex<n-1 && price[sellIndex+1]> price[sellIndex]){
                        sellIndex++;
                     }
                     i = sellIndex+1;
                    pairs.add("("+buyIndex+" "+sellIndex+")");
                }
            }
        }
        if( pairs.size() == 0 ){
            System.out.println("No Profit");
            return;
        }
        String op = "";
        for (String string : pairs) {
            op+=string+" ";
        }
        op.trim();
        System.out.print(op);
        return;
    }

    public void stockBuySellOptimized(int[] price, int n) {
        // code here
        //String pairs = "";
        int count = 0;
        int buyIndex = 0,sellIndex = 0;
        for( int i=1; i<n ; i++) {
            if(price[i]>price[i-1]){
                buyIndex = i-1;
                if(buyIndex+1 < n){
                    sellIndex = buyIndex+1;
                     while(sellIndex<n-1 && price[sellIndex+1]> price[sellIndex]){
                        sellIndex++;
                     }
                     i = sellIndex+1;
                     count = 1;
                     System.out.print("("+buyIndex+" "+sellIndex+") ");
                     //pairs+="("+buyIndex+" "+sellIndex+") ";
                }else{
                    
                }
            }
        }
        if(count == 0 ){
            System.out.println("No Profit");
        }else{
            System.out.println();
        }
    }
}
