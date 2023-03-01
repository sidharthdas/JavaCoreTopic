package Oct4Th2022.leetcode;

import mapAllFunctionalities.StudentDTD;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  01/03/23
 */
public class Preparation {
    public static void main(String[] args) {

        //Kadane Algorithm
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int sum = 0;
        int maxi = arr[0];

        int len = arr.length;

        for (int i = 0; i < len; i++) {
            sum += arr[i];
            maxi = Math.max(sum, maxi);
            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(maxi);
    }

    List<StudentDTD> list = Arrays.asList(
            new StudentDTD("t1", "8", "D", "000", "test", "2009", "feb"),
            new StudentDTD("t2", "8", "F", "000", "test", "2009", "feb"),
            new StudentDTD("t3", "9", "D", "000", "test", "2009", "feb"),
            new StudentDTD("t4", "9", "D", "000", "test", "2010", "mar"),
            new StudentDTD("t5", "9", "K", "000", "test", "2012", "mar"),
            new StudentDTD("t6", "10", "D", "000", "test", "2010", "mar")
    );


}
