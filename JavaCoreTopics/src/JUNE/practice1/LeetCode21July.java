package JUNE.practice1;

import java.time.LocalDate;
import java.util.*;

/**
 * @author sidharthdas on 21/07/21.
 */
public class LeetCode21July {

    public static void main ( String[] args ) {

     String s = "sid-dar";

     String s1 = s.substring(0, 3);
     String s2 = s.substring(3+1, s.length());
     System.out.println(s1+"/"+s2);

       // String s1 = s.replaceAll("-", "");
        //System.out.println(s1);

    }

    public String dayOfTheWeek(int day, int month, int year) {

        LocalDate date1 = LocalDate.of(year,month  ,day);
        LocalDate dt = LocalDate.parse(date1.toString());

        System.out.println(dt.getDayOfWeek());
        Map<String, String> map = new HashMap<>();
        map.put("SUNDAY", "Sunday");
        map.put("MONDAY", "Monday");
        map.put("TUESDAY", "Tuesday");
        map.put("WEDNESDAY", "Wednesday");
        map.put("THURSDAY", "Thursday");
        map.put("FRIDAY", "Friday");
        map.put("SATURDAY", "Saturday");






        return map.get(dt.getDayOfWeek());

    }

    public String reverseOnlyLetters(String s) {

        String s1 = s.replaceAll("-", "");

        int size = s1.length();
        String str = "";
        for(int i = size-1; i>=0; i--){
            str+= s1.charAt(i)+"";
        }




        int counter = 0;
        String[] arr = s.split("");
        int arrSize = arr.length;
        Map<String, List<Integer> > map = new HashMap<>();
        for(int i = 0; i < arrSize; i++){
            if(arr[i].equals("-")) {
                if (map.size() == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    map.put("-", l);

                }else{
                    List<Integer> l = map.get("-");
                    l.add(i);
                    map.put("-", l);
                }
            }
        }

        List<Integer> list = map.get("-");
        String result = "";
       for(int i : list){
           String s11 = str.substring(0, i);
           String s22 = str.substring(i,str.length());
           str = s11+"-"+s22;

       }
        return str;
    }
}
