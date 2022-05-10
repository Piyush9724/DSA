package Arrays.SmallerandLarger;

public class LowerUpperBounds {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 8,8,8,8,10, 11, 12, 19,19};
        //int[] arr ={4,4,5,5,6};
        // System.out.println(bs_lower_bound(arr, arr.length, 3));
        // System.out.println(bs_upper_bound(arr, arr.length, 8));
        Solve1 s = new Solve1();
        int res[] = s.getMoreAndLess(arr, 12, 19);
        System.out.println(res[0]+" "+res[1]);
    }
    static int bs_lower_bound(int a[], int n, int x) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid =  l + (h - l) / 2;
            if (x <= a[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l-1;
    }    
    
    static int bs_upper_bound(int a[], int n, int x) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid =  l + (h - l) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
    
}

class Solve1 {
    public int[] getMoreAndLess(int[] arr, int n, int x) {
        // code here
        int less = bs_lower_bound(arr, n, x) + 1;
        int more = n - bs_upper_bound(arr, n, x);
        int equal = n - less - more;
        System.out.println(less + " "+ equal+" "+more);
        int res[] = {less+equal, more+equal};
        return res;
    }

    static int bs_lower_bound(int a[], int n, int x) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid =  l + (h - l) / 2;
            if (x <= a[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l-1;
    }    
    
    static int bs_upper_bound(int a[], int n, int x) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid =  l + (h - l) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

}
