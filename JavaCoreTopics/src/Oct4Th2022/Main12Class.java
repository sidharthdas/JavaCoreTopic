package Oct4Th2022;

/**
 * @author Sidharth Das
 * created on  07/03/23
 */
public class Main12Class {

    public static void main(String[] args) {

        System.out.println(findFirstNonDuplicate(new char[]{'a', 'b', 'c', 'a', 'c', 'e', 'b', 'd'}));
    }

    public static char findFirstNonDuplicate(char[] arr) {

        String s = String.valueOf(arr);


        int len = arr.length;

        for (int i = 0; i < len; i++) {

            if (s.indexOf(String.valueOf(arr[i])) == s.lastIndexOf(String.valueOf(arr[i]))) {

                return arr[i];
            }
        }

        return '0';
    }

}
