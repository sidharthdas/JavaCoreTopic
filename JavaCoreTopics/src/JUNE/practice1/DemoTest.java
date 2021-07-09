package JUNE.practice1;

import java.util.*;

/**
 * @author sidharthdas on 09/07/21.
 */
public class DemoTest {

    public static void main ( String[] args ) {

        String s = "My name is Sidharth Das";

        Map<String, Integer> map = new HashMap<>();

        String str[]  = s.split(" ");

        String strWithoutSp = "";

        for(String s1 : str){
            strWithoutSp+=s1;
        }
        strWithoutSp = strWithoutSp.toLowerCase();

        String[] s2 = strWithoutSp.split("");

        int size = s2.length;

        for(int i = 0; i < size; i++ ){
            if(map.containsKey(s2[i])){
                map.put(s2[i], map.get(s2[i])+1);
            }else{
                map.put(s2[i], 1);
            }
        }

        List<String> list = new ArrayList<>();

        for(String ss: s2){
            if(!list.contains(ss)) {
                list.add(ss);
            }
        }

        for(String sss : list){

            System.out.println(sss+" : "+map.get(sss));
        }

    }
}
