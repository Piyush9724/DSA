package Arrays;

public class BinarySearch {
    static int arr[] = {10,20,30,40,50,60,70,80,90};
    public static void main(String[] args) {
        System.out.println(binarySearch(0, arr.length-1, 12));
    }

    public static int binarySearch(int l, int r, int x){
        if( r < l){
            return -1;
        }
        int mid = Math.floorDiv(l+r, 2);
        if( arr[mid]  == x) return mid;
        if(arr[mid] >  x ) return binarySearch(l, mid-1, x);
        else return binarySearch(mid+1, r, x);
    }
}
