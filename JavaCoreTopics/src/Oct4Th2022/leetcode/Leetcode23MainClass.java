package Oct4Th2022.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sidharth Das
 * created on  16/01/23
 */
public class Leetcode23MainClass {

    public static void main(String[] args) {

    }
}

class NumberContainers {
    Map<Integer, Integer> map;

    public NumberContainers() {
        map = new TreeMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);
    }

    public int find(int number) {
        if(map.entrySet().stream().filter(x -> x.getValue() == number).count() == 0){
            return -1;
        }
        Map.Entry<Integer, Integer> e = map.entrySet().stream().filter(x -> x.getValue() == number)
                .findFirst().get();
        return e.getKey();
    }
}