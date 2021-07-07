package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sidharthdas on 07/07/21.
 */
public class LeetCodeSortestElement {

    public static void main ( String[] args ) {

        LeetCodeSortestElement leetCodeSortestElement = new LeetCodeSortestElement();

       // int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

       // System.out.println(leetCodeSortestElement.kthSmallest(arr, 8));


        int[] a = {1, 3};
        int[] b = {2};

        System.out.println(leetCodeSortestElement.findMedianSortedArrays(a, b));
    }


    public int kthSmallest ( int[][] matrix, int k ) {
        List< int[] > list = new ArrayList<>();
        List< Integer > mainList = new ArrayList<>();

        for (int ar[] : matrix) {
            for (int i = 0; i < ar.length; i++) {
                mainList.add(ar[i]);
            }
        }

        System.out.println(mainList);
        Collections.sort(mainList);

        return mainList.size() >= k ? mainList.get(k - 1) : -1;


    }

    public double findMedianSortedArrays ( int[] nums1, int[] nums2 ) {

        List< Integer > list = new ArrayList<>();

        for (int i : nums1) {
            list.add(i);
        }

        for (int i : nums2) {
            list.add(i);
        }

        Collections.sort(list);

        if (list.size() % 2 != 0) {
            double d = Double.valueOf(list.get((list.size()/2)+1));
           // double ciel =  Math.ceil(d);

            return d;

        }else if(list.size() % 2 == 0){
            int center = list.size() /2;
            double d = Double.valueOf(list.get(center)+list.get(center-1)) / 2;
            return d;
        }

        return 0.0;
    }
}
