package Arrays;
// { Driver Code Starts
    import java.io.*;
    import java.util.*;

    
    
    public class TrappingRainWaterWrong {
    
        public static void main (String[] args) throws IOException {
            Scanner sc  = new Scanner(System.in);
            int n =  sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            //System.out.println(TrappingRainWaterSolutionWrong.trappingRainWater(arr, n));
            sc.close();
        }
    }
    
    // } Driver Code Ends
    
    
    class TrappingRainWaterSolutionWrong{

        static long trappingWaterWrong2(int arr[], int n) { 
            int start = 0;
            int startIndex = 0;
            int end = 0;
            int endIndex = 0;
            int count = 0;
            long water = 0;
            long actualTilesStartToEnd = 0;
            long actualTilesExcludingStartEnd =0 ;
            //long blockStartEnd = 0;
            int i;
            for(i=1; i<n;i++){
                if(arr[i]>arr[i-1]){
                    start = arr[i];
                    startIndex = i;
                    break;
                }
            }
            for(i = startIndex;i<n-2;i++){
                startIndex = i;
                start = arr[startIndex];
                actualTilesStartToEnd = start;
                while(i<n-1 && arr[i+1] < arr[i]){
                    actualTilesStartToEnd+=arr[i+1];
                    count++;
                    i++;

                }     
               // blockStartEnd = (count+2)*start;
                end = arr[i+1];
                endIndex = i+1;
                actualTilesStartToEnd += end;
                water += ( ((count+2) * start) - (( actualTilesStartToEnd) + (actualTilesExcludingStartEnd)) );
                start = 0;
                end = 0;
                count = 0;
                actualTilesStartToEnd = 0; 
            }
            
            
            return water;
        }

        
        static long trappingRainWaterWrong3(int arr[], int n){
            ArrayList<Integer>  pairs = new ArrayList<>();
            int start = 0, end = 0,i=1;
            while(i<n)
            {
                if(arr[i]>arr[i-1]){
                    start = i;
                    if(start+1 < n){
                        end = start+1;
                        while(end<n-1 && arr[end]<arr[end-1]){
                           end++;
                         }
                         //end++;
                         pairs.add(start);
                         pairs.add(end);
                         i = end;
                    }else{
                        i++;
                    }
                }else{
                    i++;
                }
            }
            System.out.println(pairs);
            int water = 0,j=0;
            while(j<pairs.size()){
                start = pairs.get(j);
                end = pairs.get(j+1);
                int blockSize =  Math.min(arr[start],arr[end]);
                int tiles = 0;
                int count = end - (start+1);
                for(int x =start+1;x<end;x++){
                    if(arr[x]>= blockSize){
                        tiles+=blockSize;
                    }else{
                        tiles+=arr[x];
                    }
                }
                water += ( ((count+2) * blockSize) - ( tiles + (2*blockSize) ) );
                j+=2;
            }
            System.out.println("water :: "+water);
            return water;
        }

        
       //This was First approach for calculating hole with max water
        static long trappingWaterWrong(int arr[], int n) { 
            // Your code here
            //cannot putninset order will get worng and elements will be missing from original array
            //Set<Integer> set =  Arrays.stream(arr).boxed().collect(Collectors.toSet());
            //arr = set.stream().mapToInt(Number::intValue).toArray();
            
            int large = 0;
            int sLarge  = -1;
            for(int i =1;i<n;i++){
                if(arr[i]>=arr[large]){
                    if(arr[i]==arr[large] && sLarge == -1 ){
                        large =  i;
                    }else{
                        sLarge = large;
                        large = i;
                    }
                }
                else if( arr[i] != arr[large] && ( sLarge ==-1 || arr[i] > arr[sLarge]) ){
                    sLarge = i;
                }
            }
            
            System.out.println("large "+large+" :: "+ arr[large]);
            System.out.println("slarge "+sLarge+" :: "+ arr[sLarge]);
            if ( (large-sLarge == 1 ) || (large-sLarge == -1 ) ){
                return (long)0;
            }else{
                long res = 0;
                long tiles = 0;
                int count = 0;
                for(int i = Math.min(large,sLarge)+1;i< Math.max(large,sLarge);i++){
                    count++;
                    tiles += arr[i];
                }
                System.out.println("count :: "+ count);
                System.out.println("tiles :: "+ tiles);
                res = arr[sLarge]*count;
                res -= tiles;
                return res;
            }
        } 
    }
    
/*
ip 1 :
7
8 8 2 4 5 5 1

ip2 :
10
1 1 5 2 7 6 1 4 2 3

ip3:
8
8 0 0 5 9 2 3 5

ip:
4
7 4 0 9
*/

    
    