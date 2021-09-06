package JavaCoreTopicsImplementation17thJul2021.practice.practice05thSept2021.practiceprogram;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 05/09/21.
 */
public class MainClass1 {

    // Write code to check a String is palindrome or not?

    public static void main ( String[] args ) {

        String s1 = "aviva";
        int size = s1.length();
        String s2 = "";
        for (int i = size - 1; i >= 0; i--) {
            s2 += s1.charAt(i) + "";
        }

        boolean b = s1.equals(s2);
        System.out.println(b);


        List< Integer > l = new ArrayList<>();
        l.add(0);


        System.out.println(l);


    }


    public int[] createTargetArray ( int[] nums, int[] index ) {

        List< Integer > list = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            list.add(0);
        }

        for (int i = 0; i < size; i++) {
            list.add(index[i], Integer.valueOf(nums[i]));
        }

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;

    }


    public int findCenter ( int[][] edges ) {
        List< Integer > l = new ArrayList<>();
        for (int i[] : edges) {
            l.add(i[0]);
            l.add(i[1]);
        }

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : l) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        map = map.entrySet().stream().sorted(Map.Entry.< Integer, Integer >comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
        int i = 0;
        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            i = m.getValue();

            break;
        }
        System.out.println(map);
        if(i == edges.length){
            return i;
        }else{
            return -1;
        }
    }


}
