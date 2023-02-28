package algorithms;

/**
 * @author Sidharth Das
 * created on  28/02/23
 */
public class KadaneAlorithm {

    public static void main(String[] args) {

        //Maximum Sum of Continious sub-array
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int len = arr.length;
        int sum = 0;
        int maxi = arr[0];
        for (int i = 0; i < len; i++) {
            sum = sum + arr[i];
            maxi = Math.max(maxi, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Maximum : " + maxi);
    }
}
