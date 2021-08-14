package JavaCoreTopicsImplementation17thJul2021.practice.practice13thAug2021.leetcode;

/**
 * @author sidharthdas on 14/08/21.
 */
public class MainClass {


    public static void main ( String[] args ) {

        new MainClass().twoSum(new int[]{5,25,75}, 100);

    }


    public int countGoodTriplets ( int[] arr, int a, int b, int c ) {
        int size = arr.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if(Math.abs(arr[i] - arr[j] )<= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public int[] twoSum(int[] numbers, int target) {

        int size = numbers.length;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i != j){
                    System.out.println(numbers[i]);
                    System.out.println(numbers[j]);
                    System.out.println("-----------------");
                    if(numbers[i]+numbers[j] == target){
                        return new int[]{i+1, j+1};
                    }
                }
            }
        }

        return null;
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int dist = 0;

        dist = (dist + 1 ) % distance.length;

        int clockWise = 0;
        int antiClockWise = 0;

        while(true){

        }

    }
}
