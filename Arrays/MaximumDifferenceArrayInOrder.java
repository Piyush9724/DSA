package Arrays;

public class MaximumDifferenceArrayInOrder {
    public static void main(String[] args) {
        int nums[] = {2,3,10,6,4,8,1};
        System.out.println(maximumDifference(nums));
        System.out.println(maximumDifferenceOptimal(nums));
    }

    //TC O(n^2) not optimal
    public static int maximumDifference(int[] nums){
        int diff = Integer.MIN_VALUE;
        for(int j=1;j<nums.length;j++){
            for(int i =0;i<j;i++){
                if( nums[i] < nums[j] && nums[j]-nums[i] > diff)
                    diff = nums[j]-nums[i];
            }
        }
        return diff;
    }

    //optimal o(n)
    public static int maximumDifferenceOptimal(int[] nums){
        int maxDiff = Integer.MIN_VALUE;
        int min = nums[0];
        for(int j=0;j<nums.length;j++){
            maxDiff = Math.max(nums[j]-min, maxDiff);
            min = Math.min(min, nums[j]);
        }
        return maxDiff > 0? maxDiff : -1;
    }

}
