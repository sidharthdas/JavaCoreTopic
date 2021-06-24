package JUNE.reverseStringWithRecurssionAndWithOut;

/**
 * @author sidharthdas on 24/06/21.
 */


public class ReverseAStringWithRecursionAndWithoutRecursion {

    public static void main ( String[] args ) {
        reverseWithoutRecursion("Sidharth");

        reverseWithRecursion("Sidharth");

    }

    public static String reverseWithoutRecursion(String s){
        int size = s.length();
        String s1 = "";
        char[] srr = s.toCharArray();
        for(int i = size-1; i >=0; i--){
            s1+= String.valueOf(srr[i]);
        }
        System.out.println(s1);
        return s1;
    }

    public static  void reverseWithRecursion( String s){
        if(s == null || s.length() <=1){
            System.out.print(s);
        }else{
            System.out.print(s.charAt(s.length()-1));
            reverseWithRecursion(s.substring(0, s.length()-1));

        }



    }
}
