package Oct4Th2022.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sidharth Das
 * created on  12/01/23
 */
public class Leetcode2MainClass2 {

    public static void main(String[] args) {

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] finalRes = new int[k];
        for(int[] log : logs){
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }

        for (int key : map.keySet()) {
            finalRes[map.get(key).size() - 1]++;
        }
        return finalRes;
    }
}
