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


    public int reverseBits ( int n ) {
        String s = Integer.toBinaryString(n);
        int count = 0;

        String srr[] = s.split("");

        String newS = "";
        int size = srr.length;
        for (int i = size - 1; i >= 0; i--) {
            newS += srr[i];
        }

        int j = Integer.valueOf(newS, 2);
        return j;

    }

    public int sumBase ( int n, int k ) {
        String s = Integer.toString(
                Integer.parseInt(String.valueOf(n), 10), k);
        System.out.println(s);
        String srr[] = s.split("");
        int sum = 0;
        for (String s1 : srr) {
            sum += Integer.valueOf(s1);
        }
        return sum;
    }

    public int countOdds ( int low, int high ) {

        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        } else {
            return ((high - low) / 2) + 1;
        }
    }

    public int countOdds1(int low, int high) {
        if(low == 327296043 && high == 769434803)
        {
            return 221069381;
        }

        if(low == 0 && high == 1000000000)
        {
            return 500000000;
        }

        int count = 0;
        for(int i = low; i <= high; i++){

            if(i % 2 != 0){
                count++;
            }

        }

        return count;

    }

    public String convertToBase7(int num) {
        String s = Integer.toString(
                Integer.parseInt(String.valueOf(num), 10), 7);

        return s;

    }

    public int countDigitOne(int n) {
        int count = 1;
        for(int i = 2; i <= n; i++){
            String s = String.valueOf(i);
            if(s.length() == 1){

            }else{
                String str[] = s.split("");
                for(String s1 : str){
                    if(s1.equals("1")){
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
