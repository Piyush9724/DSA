package Arrays;
import java.io.*;

public class LargestElement {
	public static void main(String[] args) throws IOException
	{
        int arr[] = {1,3,66,7,33,88,3,4,5};
        System.out.println(largest(arr, arr.length));
	}
    public static int largest(int arr[], int n)
    {
        int largest=arr[0];
        for(int i=1;i<n;i++){
            if( arr[i] > largest) largest  = arr[i];
        }
        return largest;
    }
}