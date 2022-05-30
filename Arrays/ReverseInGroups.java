package Arrays;
import java.io.*;
import java.util.*;

public class ReverseInGroups {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        
        //while testcases exist
        while(t-->0){
            
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<>();            
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }
            
            ReverseInGroupsSolution obj = new ReverseInGroupsSolution();
            obj.reverseInGroups(arr, n, k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}

// } Driver Code Ends

class ReverseInGroupsSolution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int l =1, r = Integer.min(n,k);
        while(l<=n){
            reverseArray(arr,l,r);
            l +=k;
            r = Integer.min(n, r+k);
        }
    }
    void reverseArray(ArrayList<Integer> arr, int from, int to){
        from = from-1;
        to = to-1;
        while(from < to){
            arr.set(from,arr.get(from) + arr.get(to));
            arr.set(to, arr.get(from) - arr.get(to));
            arr.set(from,arr.get(from) - arr.get(to));
            from++;
            to--;
        }
    }
}

