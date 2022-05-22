package Arrays;

public class MinimumConsecutiveFlips {
    public static void main(String[] args) {
        //int a[] = {1,1,0,0,0,1,1};
        int a[] = {1,0,0,0,1,0,0,1,1,1,1};
       // int a[] = {0,0,1,1};
        //minimumConsecutiveFlips(a, a.length);
        printGroups(a, a.length);
    }

    //Optimal Approach O(n) but one traversal
    public static void printGroups(int a[], int n){
        for(int i=1;i<n;i++) {
            if( a[i] !=  a[i-1]){
                if( a[i] !=  a[0]){
                    System.out.print("From "+i+" to ");
                }else{
                    System.out.print(i-1+"\n");
                }
            }
        }
        if(a[n-1] != a[0]){
            System.out.print(n-1+"\n");
        }
    }

    //Naive Approach  O(n)  but two traversals
    public static void minimumConsecutiveFlips(int a[], int n) {
        int noOfCon1 = 0;
        int noOfCon0 = 0;
        int i=1;
        boolean x =  a[0] == 1? true: false;
        while(i<n){
            if(x){
                if( a[i] == 1){
                    x = true;
                }else{
                    noOfCon1++;
                    x = false;
                }
                i++;
            }else{
                if(a[i] == 0){
                   x = false;
                }else{
                    noOfCon0++;
                    x =  true;
                }
                i++;
            }
        }
        if(a[n-1] == 1) noOfCon1++;
        else noOfCon0++;
        System.out.println(noOfCon0);
        System.out.println(noOfCon1);

        int minElem = noOfCon0 < noOfCon1 ? 0: 1;
        x = true;
        for(i=0;i<n;i++){
            if(a[i] == minElem && x){
                System.out.print("From "+ (i));
                x = false;
            }
            if(a[i] != minElem && !x ){
                System.out.print(" to "+ (i-1)+"\n");
                x = true;
            }
        }
    }
}
