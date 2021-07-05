package leetcode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author sidharthdas on 05/07/21.
 */


interface A{
    void m1();

}

class B{
    public void m1(){
        System.out.println("m1");
    }
}



public class MyPowerMainClass  extends B implements A{

    public static void main ( String[] args ) {

        Scanner s = new Scanner(System.in);
        String noOfTestCases1 = s.nextLine();
        // String str = s.nextLine();
        int noOfTestCases = Integer.parseInt(noOfTestCases1);
        for(int i = 0; i < noOfTestCases; i++){
            String str = s.nextLine();
            String[] strArr = str.split(" ");
            System.out.println(Integer.parseInt(strArr[0])+Integer.parseInt(strArr[1]));
        }



    }



    public int reverse1(int x) {
        int z = x;
        if(z < 0){
            z = (-1) * x;
        }

        System.out.println(Math.abs(z));
        String s = String.valueOf(z);
        if(String.valueOf(s.charAt(0)).equals("-")){
            s = s.substring(1);
        }
        String reverseString = "";
        int size = s.length();
        for(int i = size-1; i >=0 ; i--){
            reverseString =reverseString+ s.charAt(i);
        }

        if(reverseString.equals(String.valueOf(z))){
            return x;
        }

        if(reverseString.length() > 9){
            BigInteger b1 = new BigInteger(reverseString);
            BigInteger b2 = new BigInteger("2147483647");
            if(b1.compareTo(b2) > 0){
                return  0;
            }else if(b1.compareTo(b2) < 0){
                if(x <0){
                    return Integer.parseInt(String.valueOf(b1)) * -1;
                }
                return Integer.parseInt(String.valueOf(b1));
            }
            return 0;
        }
        int b = Integer.parseInt(reverseString);
        if(x < 0){
            return -1*b;
        }
        return b;
    }

}
