import java.io.*;

class A10_CheckForStringRotation {

    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
          //  A10_CheckForStringRotation obj = new A10_CheckForStringRotation();

            // calling areRotations method
            // of class Rotate and printing
            // "1" if it returns true
            // else "0"
            if (A10_CheckForStringRotationSolution.areRotations(s1, s2)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
// } Driver Code Ends

class A10_CheckForStringRotationSolution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if ((s1 + s1).contains(s2))
            return true;
        return false;
    }

    public static boolean areRotationsNaive(String s1, String s2) {
        // Your code here
        if (s1.length() != s2.length())
            return false;
        StringBuilder s = new StringBuilder(s2);
        for (int i = 0; i < s1.length(); i++) {
            s = s.append(s.charAt(0));
            s.deleteCharAt(0);
            // System.out.println(s);
            if (s.toString().equals(s1))
                return true;
        }
        return false;
    }

}

