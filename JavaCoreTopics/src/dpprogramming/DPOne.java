package dpprogramming;

/**
 * @author Sidharth Das
 * created on  07/12/22
 */
public class DPOne {

    public static void main(String[] args) {

        int n = 6;

        int[] arr = new int[n+1];

        for(int i = 0; i <= n; i++){
            arr[i] = -1;
        }

        System.out.println(fibonacci(n, arr));
    }

    public static int fibonacci(int n, int[] arr){
        if(n <= 1){
            return n;
        }
        if(arr[n] != -1){
            return arr[n];
        }
        arr[n] =  fibonacci(n - 1, arr) + fibonacci(n -2, arr);

        return arr[n];
    }

    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int arr[] = new int[len + 1];

        for(int i = 0; i <= len ; i++){
            arr[i] = -1;
        }

        int ans = Math.max(val(cost, len-1, arr), val(cost, len - 2, arr));

        return ans;

    }

    public int val(int[] cost, int n, int[] arr){
        if(n == 0){
            return cost[0];
        }
        if(n == 1){
            return  cost[1];
        }
        if(arr[n] != -1){
            return arr[n];
        }

        arr[n] = cost[n] + Math.min(val(cost, n -1 , arr), val(cost, n -2, arr));

        return arr[n];

    }
}
