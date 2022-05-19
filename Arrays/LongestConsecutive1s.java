package Arrays;

public class LongestConsecutive1s {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(887));
    }

    public static int maxConsecutiveOnes(int N) {

        // Your code here
        String number = Integer.toBinaryString(N);
        System.out.println(number);
        int longestSeqCount = 0;
        int seq = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '1') {
                seq++;
            } else {
                seq = 0;
            }
            if (seq > longestSeqCount)
                longestSeqCount = seq;
        }
        return longestSeqCount;

    }
}
