package Arrays;

public class RemoveDuplicatesFromArray {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + " ");
        }
        System.out.println(sb);
      }
    public static void main(String[] args) {
        int a[] = {10,20,20,30,30,30};
        remove_duplicate(a, a.length);
    }
    static int remove_duplicate(int a[],int n){
        // code here
       int j=1;
       for(int i=1;i<n;i++){
           if(a[i]!=a[j-1]){
            a[j]=a[i];
            j++;
        }
         
       }
       return j;
    }


    
    public static int remove_duplicateWrong2(int A[],int N){
        int i =1;
        int count = 1;
        while(i<N){
            if(A[i] == A[i-1]){
                if(A[i] == A[N-1]) break;
                int j = i+1;
                while(j < N && A[i] == A[j]){
                    if(j+1 < N)
                        j++;
                    else    
                        break;
                }
                A[i] = A[j];
                i=j;
                count++;
            }else {
                i++;
                count++;
            }
        }
        for(i=0;i<N;i++)System.out.print(A[i]+" ");
        System.out.println("\n Count :: "+ count);
        return 0;
    }




    //Wrong approach
    static int remove_duplicate_Wrong(int A[],int N){
        int i = 1;
        int count = 0;
       // int lastModify = 0;
        while(i<N){
            System.out.println(A[i] + " "+ A[i-1]);
            if(A[i] == A[i-1]){
                int j= i;
                System.out.println(A[j]+" "+A[j-1]);
                while( j<N  && A[j-1] == A[j] && A[j] != A[count-1]){
                    j++;
                }
                if(j<N){
                    A[i] = A[j];
                    i=j;
                    count++; 
                }else{
                    A[i] = A[N-1];
                    i = N;
                } 
            }else{
                count++;
                i++;
            }
        }
        for(i =0;i<N;i++){
            System.out.print(A[i]+" ");
        }
        return count;
    }


}
