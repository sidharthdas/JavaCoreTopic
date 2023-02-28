package Oct4Th2022.leetcode;

/**
 * @author Sidharth Das
 * created on  27/02/23
 */
public class MainClass1 {

    public static void main(String[] args) {
        //Kadane Algo

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int sum = 0;
        int maxi = arr[0];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            maxi = Math.max(maxi, sum);

            if(sum < 0){
                sum = 0;
            }
        }
        System.out.println(maxi);
    }
}
