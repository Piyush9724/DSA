package Arrays;

import java.io.*;

public class FrequenciesofLimitedRangeArrayElements {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            FrequenciesofLimitedRangeArrayElementsSolution ob = new FrequenciesofLimitedRangeArrayElementsSolution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class FrequenciesofLimitedRangeArrayElementsSolution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // code here
        int max = arr[0];
        for (int i = 0; i < N; i++) {
            max = Integer.max(max, arr[i]);
            arr[i]--;
        }

        for (int i = 0; i < N; i++) {
            int iModMax = arr[i] % max;
            if (iModMax < N) {
                arr[iModMax] += max;
            }
        }

        for (int i = 0; i < N; i++) {
            arr[i] /= max;
        }
    }
}
