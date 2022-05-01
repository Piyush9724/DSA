package BitMagic;

public class BinaryToGray {
    public static void main(String[] args) {
        System.out.println(greyConverter(12));
        System.out.println(greyConverterOptimal(12));
    }

    //First Approach
    public static int greyConverter(int n) {
        // Your code here 
        //String greyCode = "";
        int greyDec = 0;
        int grey=0;
        int i = 0;
        while(n>0){
            grey = (((n>>0)&1) ^ ((n>>1)&1));
           // greyCode =  grey + greyCode;
            n = n>>1;
            if(grey == 1)
                greyDec += Math.pow(2, i);
            i++;
        }
        //System.out.println(greyCode);
        return greyDec;
    }

    //Optimal Approach
    public static int greyConverterOptimal(int n) {
        // Your code here 
        return (n>>1)^n;
    }
}
