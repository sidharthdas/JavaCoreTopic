package Oct4Th2022.leetcode;

import java.util.HashMap;
import java.util.Map;

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
        map = new HashMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);
    }

    public int find(int number) {
        Map.Entry<Integer, Integer> e = map.entrySet().stream().filter(x -> x.getValue() == number)
                .sorted(Map.Entry.comparingByKey()).findFirst().get();
        if( e == null){
            return -1;
        }
        return e.getKey();
    }
}