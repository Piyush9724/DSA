package Arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfElements {
    public static void main(String[] args) {
       // int arr[] = {10,10,10,25,30,30};
       // int arr[] = {10,10,10,10};
       // int arr[] = {10,20,30};
       int arr[] = {2,2,2,2,2,2,4,4,4,4,6,6,7,8,9};

        System.out.println(findFrequencies(arr, arr.length));
    }

    public static Map<Integer, Integer> findFrequencies(int[] arr, int n){
        Map<Integer,Integer> freqMap = new HashMap<>();
        int curEle = arr[0];
        int curFreq = 1;
        for(int i=1;i<n;i++){
            if(arr[i] == arr[i-1]){
                curFreq++;
            }else{
                freqMap.put(curEle, curFreq);
                curEle = arr[i];
                curFreq = 1;
            }
        }
        freqMap.put(curEle, curFreq);
        return freqMap;
    }
}
