package JUNE.programmingQuestion;

/**
 * @author sidharthdas on 01/07/21.
 */
public class LeetCode {


    public static void main ( String[] args ) {
    //haystack = "hello", needle = "ll"

        strStr("aaa","a");

      //  System.out.println("aaa".indexOf('a'));

      System.out.println(  multiply("123", "123456789"));


    }

    public static int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
       else if(haystack.contains(needle)){
           int index = haystack.indexOf(needle);
           System.out.println(index);
            return index;
        }else{
           return -1;
        }


    }

    public static  String multiply(String num1, String num2) {



        Long mul = Long.valueOf(Integer.parseInt(num1)) *Long.valueOf(Integer.parseInt(num2));

        return String.valueOf(mul);

    }
}
