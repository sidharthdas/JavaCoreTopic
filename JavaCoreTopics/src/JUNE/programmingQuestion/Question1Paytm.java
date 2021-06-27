package JUNE.programmingQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sidharthdas on 27/06/21.
 */


/*Q1) Given an array of integers where each element represents the max number of steps that can be made forward from that element.
        The task is to find the minimum number of jumps to reach the end of the array (starting from the first element).
        If an element is 0, then cannot move through that element.*/
public class Question1Paytm {

    public static void main ( String[] args ) {

        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        int arr1[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int arr2[] = {5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJump1(arr2, arr2.length));

    }


    public static int minJump1(int arr[], int n) {

        List< Integer > num = new ArrayList<>();
        num.add(arr[0]);
        for (int i = arr[0]; i < arr.length; ) {
            if (arr[i] != 1) {
                int value = arr[i];
                num.add(value);
                int newIndex = (value + i) - 1;
                if(newIndex > arr.length-1){
                    num.add(arr[arr.length-1]);
                    break;
                }
                i = newIndex;
            } else {
                int value = arr[i];
                num.add(value);
                int newIndex = i + 1;
                if(newIndex > arr.length-1){
                    num.add(arr[arr.length-1]);
                    break;
                }
                i = newIndex;


            }
        }
        System.out.println(num);
        return num.size() -1;
    }






    public static int minJump(int arr[]) {

        int jump = 0;
        int steps = 0;
        boolean flag = true;
        int totalSteps = arr.length;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                flag = false;
                break;
            }

            steps += arr[i];
            jump += 1;
            if(steps >= totalSteps){
                break;
            }
        }

        return jump;


    }


}
