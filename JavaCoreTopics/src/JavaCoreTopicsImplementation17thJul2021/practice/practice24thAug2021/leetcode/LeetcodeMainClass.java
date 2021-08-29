package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021.leetcode;

/**
 * @author sidharthdas on 29/08/21.
 */
public class LeetcodeMainClass {

    public static void main ( String[] args ) {

    }

    public int countPrimeSetBits ( int left, int right ) {
        int countPrime = 0;
        for (int i = left; i <= right; i++) {

            String s = Integer.toBinaryString(i);
            String srr[] = s.split("");
            int count = 0;
            for (String s1 : srr) {
                if (s1.equals("1")) {
                    count++;
                }
            }

            boolean check = checkPrime(count);
            if (check == true) {
                countPrime++;
            }


        }

        return countPrime;

    }

    private boolean checkPrime ( int n ) {
        int i, m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                    //flag = 1;
                    //break;
                }
            }
            if (flag == 0) {
                return true;
            }
        }//end of else

        return false;
    }

    public int hammingWeight ( int n ) {
        String s = Integer.toBinaryString(n);
        int count = 0;

        String srr[] = s.split("");

        for (String s1 : srr) {
            if (s1.equals("1")) {
                count++;
            }
        }
        return count;
    }
}
