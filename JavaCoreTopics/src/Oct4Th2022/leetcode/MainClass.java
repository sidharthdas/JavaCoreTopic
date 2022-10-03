package Oct4Th2022.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {

    }

    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(names[i], heights[i]);
        }

        String[] finalList = new String[len];

        Map<String, Integer> m = map.entrySet().stream().sorted(Map.Entry.<String, Integer > comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Integer i = 0;
        for(Map.Entry<String, Integer> m1 : m.entrySet()){
            finalList[i] = m1.getKey();
            i++;
        }
        return finalList;
    }

    public String[] sortPeople1(String[] names, int[] heights) {
        int len = names.length;
        List<String> list = new ArrayList<>();
        //Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            list.add(names[i]+"-"+heights[i]);
        }

        Comparator<String> comparator = (String s1, String s2) ->{
          int i1 = Integer.parseInt(s1.split("-")[1]);
          int i2 = Integer.parseInt(s2.split("-")[1]);

          if(i1 > i2){
              return -1;
          }else if(i1 < i2){
              return 1;
          }else{
              return 0;
          }

        };
        String[] finalList = new String[len];
        Collections.sort(list, comparator);
        int i = 0;
        for(String s : list){
            finalList[i] = s.split("-")[0];
            i++;
        }

        return finalList;


    }
}
