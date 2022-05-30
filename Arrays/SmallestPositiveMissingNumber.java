package Arrays;

import java.util.Scanner;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            
            //taking testcases
            int t=sc.nextInt();
            while(t-->0){
                
                //input number n
                int n=sc.nextInt();
                int[] arr=new int[n];
                
                //adding elements to the array
                for(int i=0;i<n;i++)
                    arr[i]=sc.nextInt();
                    
                    SmallestPositiveMissingNumberSolution obj = new SmallestPositiveMissingNumberSolution();
                
                //calling missingNumber()
                int missing = obj.missingNumber(arr,n);
                System.out.println(missing);
            }
    }
    
}


class SmallestPositiveMissingNumberSolution {
    public static int missingNumber(int arr[], int n){
        boolean flag = false;
        for(int i = 0;i<n;i++){
            if(arr[i] == 1) flag = true;
            if(arr[i]<=0 || arr[i]>n)
                arr[i] = 0;
            else
                arr[i] -= 1;
        }

        if (flag == false) return 1;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]%n+" "+ arr[arr[i]%n] );
            arr[arr[i]%n] += n ;
        }

        for(int i = 0; i < n; i++)
        {
            arr[i] /= n;
        }
        
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 0)
                return i + 1;
        }
        
        return n + 1;
    }
}





