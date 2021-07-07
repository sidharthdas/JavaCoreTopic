package leetcode;

import java.util.*;

/**
 * @author sidharthdas on 07/07/21.
 */
public class LeetCodeSortestElement {

    public static void main ( String[] args ) {

        LeetCodeSortestElement leetCodeSortestElement = new LeetCodeSortestElement();

        // int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        // System.out.println(leetCodeSortestElement.kthSmallest(arr, 8));


        int[] a = {1, 1,2};
        int[] b = {2};

        System.out.println(leetCodeSortestElement.removeDuplicates(a));
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
            double d = Double.valueOf(list.get((list.size() / 2) + 1));
            // double ciel =  Math.ceil(d);

            return d;

        } else if (list.size() % 2 == 0) {
            int center = list.size() / 2;
            double d = Double.valueOf(list.get(center) + list.get(center - 1)) / 2;
            return d;
        }

        return 0.0;
    }


    public List< List< Integer > > threeSum ( int[] nums ) {

        List< List<Integer> > list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && i + 2 < nums.length) {

            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {

                    if ((i != j && i != k && j != k) && (nums[i] + nums[j] + nums[k] == 0)){
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i] );
                        li.add(nums[j]);
                        li.add(nums[k]);

                        list.add(li);
                    }

                }
            }
        }

        return list;

    }


    public int removeDuplicates(int[] nums) {

        List<Integer> l = new ArrayList<>();

        for(int i : nums) {
            if (!l.contains(i)) {
                l.add(i);
            }
        }
            int size = l.size();
            int[] nums1 = new int[size];

            for(int i =0 ; i < size; i++){
                nums1[i] = l.get(i);
            }

            for(int i : nums1){
                System.out.print(i+" ,");
            }

            nums = nums1;

            return size;
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            char[] a = s.toCharArray();
            Arrays.sort(a);

            String s1 = String.valueOf(a);

            if(map.containsKey(s1)){
                List<String> sList = map.get(s1);
                sList.add(s);
                map.put(s1, sList);
            }else{

                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1, list);
            }
        }

        List<List<String>> mainList = new ArrayList<>();

        for(Map.Entry<String, List<String>> m1 : map.entrySet()){
            mainList.add(m1.getValue());
        }

        return mainList;

    }


    public void rotate(int[][] matrix) {

        int[][] arr = matrix;


        for()



    }
}

