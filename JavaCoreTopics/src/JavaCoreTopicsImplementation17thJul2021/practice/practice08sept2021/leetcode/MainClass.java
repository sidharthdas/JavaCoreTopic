package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.leetcode;

import java.util.*;

/**
 * @author sidharthdas on 09/09/21.
 */
public class MainClass {


    public static void main ( String[] args ) {
       // System.out.println((Double.valueOf(12)/Double.valueOf(25));

    }

    //
    public int numOfSubarrays ( int[] arr ) {
        int arrSize = arr.length;
        //start point
        List< List< Integer > > list = new ArrayList<>();
        for (int startPoint = 0; startPoint < arrSize; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <= arrSize; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                List< Integer > l = new ArrayList<>();
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arr[j] + " ");
                    l.add(arr[j]);
                }
                System.out.println();
                list.add(l);
            }
        }

        int count = 0;

        for (List< Integer > l1 : list) {
            if (l1.size() == 1) {
                if (l1.get(0) % 2 != 0) {
                    count++;
                }
            } else {
                Optional< Integer > i = l1.stream().reduce(Integer::sum);
                if (i.isPresent() && i.get() % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countSegments ( String s ) {
        if (s.equals("")) {
            return 0;
        }
        s = s.replaceAll("\\s+", " ").trim();
        String str[] = s.split(" ");
        return str.length;
    }

    public int findSpecialInteger ( int[] arr ) {

        Map< Integer, Integer > map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int length = arr.length;
        double d = 25;
        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            double d1 = (Double.valueOf(m.getValue()) / Double.valueOf(length)) * Double.valueOf(100);
            System.out.println(d1);
            if ((Double.valueOf(m.getValue()) / Double.valueOf(length)) * Double.valueOf(100) >= d) {
                return m.getKey();
            }

        }

        return 0;

    }

    //You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
    public int[] sumEvenAfterQueries ( int[] nums, int[][] queries ) {

        int[] result = new int[queries.length];
        int index = 0;
        for (int[] arr : queries) {
            nums[arr[1]] = nums[arr[1]] + arr[0];
            int sum = 0;
            for (int i : nums) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            result[index] = sum;
        }

        return result;

    }


    public int[] sumEvenAfterQueries1 ( int[] nums, int[][] queries ) {
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (int[] arr : queries) {
            nums[arr[1]] = nums[arr[1]] + arr[0];
            if(nums[arr[1]] % 2 == 0 && arr[0] % 2 == 0){
                sum += arr[0];
            }else if(nums[arr[1]] % 2 != 0 && arr[0] % 2 != 0){
                sum += nums[arr[1]] + arr[0];
            }else if(nums[arr[1]] % 2 == 0 && arr[0] % 2 != 0){
                sum -= nums[arr[1]];
            }

            result[index] = sum;
        }

        return result;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m;

        for(int i : nums2){
            nums1[index] = i;
            index++;
        }

        Arrays.sort(nums1);


    }
}



class KthLargest {

    List< Integer > list = new ArrayList<>();
        int k = 0;
    public KthLargest ( int k, int[] nums ) {
        this.k = k;
        for(int i : nums){
            list.add(i);
        }


    }

    public int add ( int val ) {
      list.add(val);
      Collections.sort(list, Collections.reverseOrder());
        return list.get(k-1);

    }
}


class PeekingIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    int size = 0;
    int index = 0;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        size = list.size();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(index);

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(hasNext()){
            int i = index;
            index+=1;
            return list.get(i);

        }
        return 0;
    }

    @Override
    public boolean hasNext() {
        if(index >= size){
            return false;
        }
        return true;
    }
}


