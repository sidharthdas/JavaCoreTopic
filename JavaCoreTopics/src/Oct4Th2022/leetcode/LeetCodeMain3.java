package Oct4Th2022.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  08/10/22
 */
public class LeetCodeMain3 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<ValueWeigh> list = new ArrayList<>();


        for(int[] i : items1){
            list.add(new ValueWeigh(i[0], i[1]));
        }
        for(int[] i : items2){
            list.add(new ValueWeigh(i[0], i[1]));
        }

        /*List<ValueWeigh> list = new ArrayList<>();
        list.addAll(itemList1);
        list.addAll(itemList2);*/
        Map<Integer, Integer> map = new HashMap<>();

        for(ValueWeigh v : list){
            if(map.containsKey(v.getValue())){
                map.put(v.getValue(), map.get(v.getValue()) +  v.getWeight());
            }else{
                map.put(v.getValue(), v.getWeight());
            }

        }

        map = map.entrySet().stream().sorted(Map.Entry. <Integer, Integer>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));

        List<List<Integer>> finalList = new ArrayList<>();
        map.entrySet().forEach(x ->{
            List<Integer> l = new ArrayList<>();
            l.add(x.getKey());
            l.add(x.getValue());
            finalList.add(l);
        });


    return finalList;
    }

}

class ValueWeigh{

    private int value;
    private int weight;

    public ValueWeigh(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueWeigh that = (ValueWeigh) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}


