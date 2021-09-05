package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.practiceprogram;

/**
 * @author sidharthdas on 05/09/21.
 */
public class MainClass1 {

    // Write code to check a String is palindrome or not?

    public static void main ( String[] args ) {

        String s1 = "aviva";
        int size = s1.length();
        String s2 = "";
        for (int i = size - 1; i >= 0; i--) {
            s2 += s1.charAt(i) + "";
        }

        boolean b =  s1.equals(s2);
        System.out.println(b);
    }
}
