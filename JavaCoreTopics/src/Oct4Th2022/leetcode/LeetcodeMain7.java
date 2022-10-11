package Oct4Th2022.leetcode;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  10/10/22
 */
public class LeetcodeMain7 {

    public static void main(String[] args) {


    }


}

class FreqStack {

    Map<Integer, Integer> map;
    List<Integer> stack;


    public FreqStack() {
        map = new HashMap<>();
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if(map.containsKey(val)){
            map.put(val, map.get(val) + 1);
        }else{
            map.put(val, 1);
        }

        stack.add(val);

    }

    public int pop() {
        Map.Entry<Integer, Integer> entry  =  map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .entrySet().stream().findFirst().get();
        Set<Integer> s1 = map.entrySet().stream().filter(x -> x.getValue() == entry.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                        .keySet();

        List<Integer> indexes = new ArrayList<>();
        for(int s : s1){
            indexes.add(stack.lastIndexOf(s));
        }

        Collections.sort(indexes, Comparator.reverseOrder());
        int index = indexes.get(0);
        int key = stack.get(index);

        map.put(key, map.get(key) - 1);
        if(map.get(key) == 0){
            map.remove(key);
        }
        stack.remove(index);
        return key;
    }
}
