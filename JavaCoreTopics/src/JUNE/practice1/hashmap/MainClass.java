package JUNE.practice1.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 25/06/21.
 */
public class MainClass {

    public static void main ( String[] args ) {


        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("12", 121);
        map.put("13", 1123123);
        map.put("14", 14243);
        map.put("15", 12143);
        map.put("16", 112);
        map.put("17", 111);
        map.put("18", 11);

        for(Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey());
            System.out.println(m.getValue());
        }

        Map<String, Integer> map1 =  map.entrySet().stream().filter(x -> x.getValue()>0).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        map.entrySet().stream().forEach(x ->{
            System.out.println(x.getValue()+" : "+ x.getKey() );
        });
    }

    }

