package bin.JUNE.hackerrank;

/**
 * @author sidharthdas on 05/07/21.
 */


class StringComparator {

    public boolean compare ( String a, String b ) {
        if (a.compareTo(b) > 0) {
            return false;

        } else if (a.compareTo(b) < 0) {
            return false;

        } else {
            return true;
        }
    }

    public boolean compare ( int[] a, int[] b ) {
        int sizeA = a.length;
        int sizeB = b.length;

        if (sizeA != sizeB) {
            return false;
        }

        for (int i = 0; i < sizeA; i++) {
            if (a[i] != b[i]) {
                return false;
            } else {
                if (i == sizeA - 1) {
                    return true;
                }
            }

        }

        return false;

    }

    public boolean compare ( Integer a, Integer b ) {
        if (a > b) {
            return false;

        } else if (a < b) {
            return false;

        } else {
            return true;
        }
    }

}

public class MainClass {


    public static void main ( String[] args ) {

    }
}
