package Oct4Th2022.leetcode;

import java.util.*;

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
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet<>());
            map.get(log[0]).add(log[1]);
        }

        for (int key : map.keySet()) {
            finalRes[map.get(key).size() - 1]++;
        }
        return finalRes;
    }

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int len = skill.length;
        int first = 0;
        int last = len - 1;
        List<List<Integer>> l =new ArrayList<>();
        int same = skill[0] + skill[len - 1];
        while(first < last) {
            if((skill[first] + skill[last] )!= same){
                return -1;
            }
            l.add(List.of(skill[first], skill[last]));
            first++;
            last--;

        }

        long finalVal = 0;

        for(List<Integer> l1 : l){
            finalVal += (l1.get(0) * l1.get(1));
        }

        return finalVal;
    }
}
