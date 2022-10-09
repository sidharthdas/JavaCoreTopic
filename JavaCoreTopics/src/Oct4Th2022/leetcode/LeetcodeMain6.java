package Oct4Th2022.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sidharth Das
 * created on  09/10/22
 */
public class LeetcodeMain6 {

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("zzzyyy", "iiiiii"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        String[] arr1 = word1.split("");
        String[] arr2 = word2.split("");
        Map<String, Integer> map1 = new HashMap<>();
        Set<String> s = new HashSet<>();

        for (String s1 : arr1) {
            s.add(s1);
            if (map1.containsKey(s1)) {
                map1.put(s1, map1.get(s1) + 1);
            } else {
                map1.put(s1, 1);
            }
        }
        Map<String, Integer> map2 = new HashMap<>();

        for (String s2 : arr2) {
            s.add(s2);
            if (map2.containsKey(s2)) {
                map2.put(s2, map2.get(s2) + 1);
            } else {
                map2.put(s2, 1);
            }
        }
        boolean flag = true;
        for (String s1 : s) {
            int c1 = 0;
            if (map1.containsKey(s1)) {
                c1 = map1.get(s1);
            }

            int c2 = 0;
            if (map2.containsKey(s1)) {
                c2 = map2.get(s1);
            }

            if(c1 != c2){
                if((c1 > c2 ) && (c1 - c2) > 3){
                    flag = false;
                    break;
                } else if((c1 < c2 ) && (c2 - c1) > 3){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
