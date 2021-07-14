package JUNE.practice1;

import java.util.*;

/**
 * @author sidharthdas on 14/07/21.
 */

class Employee {
    public int id;
    public int importance;
    public List< Integer > subordinates;
};

public class LeetCode14thJuly {

    public static void main ( String[] args ) {
        LeetCode14thJuly leetCode14thJuly = new LeetCode14thJuly();

        System.out.println(leetCode14thJuly.frequencySort("tree"));

    }

    public int maximumProduct ( int[] nums ) {

        List< Integer > list = new ArrayList<>();

        for (int i : nums) {
            list.add(i);
        }

        int product = list.stream().reduce(0, ( a, b ) -> a * b);

        return product;

    }

    public String frequencySort ( String s ) {
        String[] str = s.split("");

        Map< String, Integer > map = new HashMap<>();
        for (String ss : str) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }

        List< Integer > list = new ArrayList<>();
        for (Map.Entry< String, Integer > m : map.entrySet()) {
            list.add(m.getValue());
        }

        Collections.sort(list);
        int sizeofList = list.size();
        String res = "";
        for (int i = sizeofList - 1; i >= 0; i--) {
            for (Map.Entry< String, Integer > m : map.entrySet()) {
                if (m.getValue() == list.get(i)) {
                    for (int j = 0; j < m.getValue(); j++) {
                        res += m.getKey();

                    }
                }
            }
        }


        return res;
    }

    public int numJewelsInStones ( String jewels, String stones ) {
        String str[] = jewels.split("");
        String str1[] = stones.split("");
        int count = 0;

        Map< String, Integer > map = new HashMap<>();

        for (String s : str) {
            if (stones.contains(s)) {
                for (String s1 : str1) {
                    if (s.equals(s1)) {
                        count += 1;
                    }
                }
            }

            map.put(s, count);
            count = 0;
        }
        int totalSum = 0;
        for (Map.Entry< String, Integer > m : map.entrySet()) {

            totalSum += m.getValue();
        }

        return totalSum;
    }

    public int majorityElement ( int[] nums ) {

        int major = nums.length / 2;

        Map< Integer, Integer > map = new HashMap<>();

        for (int num : nums) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() > major) {
                return m.getKey();
            }
        }
        return -1;
    }

    public int getImportance ( List< Employee > employees, int id ) {

        int sum = 0;

        Employee emp1 = null;

        for (Employee emp : employees) {
            if (emp.id == id) {
                emp1 = emp;
                break;
            }
        }

        sum += emp1.importance;

        List< Integer > ids = new ArrayList<>();
        ids.addAll(emp1.subordinates);

        for (int i : ids) {
            for (Employee e : employees) {
                if (i == e.id) {
                    if (e.subordinates.size() != 0) {
                        ids.addAll(e.subordinates);
                    }
                }
            }
        }

        for (int i : ids) {
            for (Employee e : employees) {
                if (e.id == i) {
                    sum += e.importance;
                    break;
                }
            }
        }


        return sum;
    }


    public int[] findErrorNums ( int[] nums ) {
        int numLen = nums.length;

        Map< Integer, Integer > m = new HashMap<>();

        for (int i : nums) {

            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }

        int size = m.keySet().size();
        int totalSum = (numLen * (numLen + 1)) / 2;

        int numMissed = m.keySet().stream().reduce(0, Integer::sum);

        int[] res = new int[2];

        for (Map.Entry< Integer, Integer > map : m.entrySet()) {
            if(map.getValue() == 2){
                res[0] = map.getKey();
                break;
            }

        }

        res[1] = totalSum - numMissed;
        return res;

    }

    public int repeatedNTimes(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){

            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }

        }


        for(Map.Entry<Integer, Integer> M : map.entrySet()){
            if(M.getValue() > 1){
                return M.getKey();
            }
        }
        return 0;
    }

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : arr){

            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }

        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> M : map.entrySet()){
            list.add(M.getValue());
        }

        Set<Integer> set = new HashSet<>(list);

        return set.size() == list.size();
    }

    public String[] findWords(String[] words) {

        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        for(String s : words){
            int count =0;

            String[] str = s.split("");

            Set<String> set = new HashSet<>();
            for(String s1 : str){
                set.add(s1);
            }


        }

        return null;
    }
}
