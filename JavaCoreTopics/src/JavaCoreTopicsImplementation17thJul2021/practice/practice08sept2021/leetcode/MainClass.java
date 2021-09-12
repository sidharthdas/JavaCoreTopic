package JavaCoreTopicsImplementation17thJul2021.practice.practice08sept2021.leetcode;

import java.util.*;

/**
 * @author sidharthdas on 09/09/21.
 */
public class MainClass {


    public static void main ( String[] args ) {
        //System.out.println((Double.valueOf(12)/Double.valueOf(25));

    }

     //
    public int numOfSubarrays ( int[] arr ) {
        int arrSize = arr.length;
        //start point
        List< List<Integer> > list  = new ArrayList<>();
        for (int startPoint = 0; startPoint < arrSize; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <= arrSize; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                List<Integer> l = new ArrayList<>();
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arr[j] + " ");
                    l.add(arr[j]);
                }
                System.out.println();
                list.add(l);
            }
        }

        int count = 0;

        for(List<Integer> l1 : list){
            if(l1.size() == 1){
                if(l1.get(0) % 2 != 0){
                    count++;
                }
            }else{
               Optional< Integer > i = l1.stream().reduce(Integer::sum);
               if(i.isPresent() && i.get() % 2 != 0){
                   count++;
               }
            }
        }

        return count;
    }

    public int countSegments(String s) {
        if(s.equals("")){
            return 0;
        }
        s = s.replaceAll("\\s+"," ").trim();
        String str[] = s.split(" ");
        return str.length;
    }
    public int findSpecialInteger(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put( i,1);
            }
        }

        int length = arr.length;
        double d = 25;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            double d1 = (Double.valueOf(m.getValue())/Double.valueOf(length)) * Double.valueOf(100);
            System.out.println(d1);
            if((Double.valueOf(m.getValue())/Double.valueOf(length)) * Double.valueOf(100) >= d){
                return m.getKey();
            }

        }

        return 0;

    }
}
