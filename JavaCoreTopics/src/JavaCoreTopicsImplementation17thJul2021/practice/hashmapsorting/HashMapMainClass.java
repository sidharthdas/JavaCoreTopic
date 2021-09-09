package JavaCoreTopicsImplementation17thJul2021.practice.hashmapsorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 28/07/21.
 */
public class HashMapMainClass {

    public static void main ( String[] args ) {

        Map< String, Integer > map = new HashMap<>();

        map.put("Sidharth", 1);
        map.put("Raju", 10);
        map.put("RAM", 19);
        map.put("sHIV", 16);
        map.put("dEV", 4);
        map.put("Sagaar", 6);
        map.put("Ramesh", 2);

        System.out.println("Sorting by Value. . . ");
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        System.out.println(map);

        System.out.println("Sorting my value reverse order. . . ");
        map = map.entrySet().stream().sorted(Map.Entry.< String, Integer >comparingByValue().reversed()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
        System.out.println(map);

    }


    public String generateTheString ( int n ) {
        String s = "";
        if (n % 2 == 0) {

            for (int i = 0; i < n - 2; i++) {
                s += "a";
            }

            s += "b";

            return s;
        } else {
            for (int i = 0; i < n; i++) {
                s += "a";
                return s;
            }
        }

        return null;
    }

    public int countSubstrings ( String s ) {

        // Pick starting point
        List< String > list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                list.add(s.substring(i, j));

            }
        }

        int count = 0;
        for (String s1 : list) {
            if (s1.length() == 1) {
                count++;
            } else if (s1.length() == 2) {
                String[] sp = s1.split("");
                if (sp[0].equals(sp[1])) {
                    count++;
                }
            } else {

                int size = s1.length();
                String req = "";
                String[] s5 = s1.split("");
                for (int j = size - 1; j >= 0; j--) {
                    req += s5[j];
                }
                if (s1.equals(req)) {
                    count++;
                }
            }
        }

        return count;
    }


    public String longestPalindrome ( String s ) {

        // Pick starting point
        List< String > list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                list.add(s.substring(i, j));

            }
        }
        Comparator< String > comparator = ( String o1, String o2 ) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        };
        Collections.sort(list, Collections.reverseOrder(comparator));

        for (String s1 : list) {
            if (s1.length() == 1) {
                return s1;
            } else if (s1.length() == 2) {
                String[] sp = s1.split("");
                if (sp[0].equals(sp[1])) {
                    return s1;
                }
            } else {
                int size = s1.length();
                String req = "";
                String[] s5 = s1.split("");
                for (int j = size - 1; j >= 0; j--) {
                    req += s5[j];
                }
                if (s1.equals(s5)) {
                    return s1;
                }

            }
        }
        return null;
    }

    //restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]
//Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest.
// For restaurants with the same rating, order them by id from highest to lowest.
// For simplicity veganFriendlyi and veganFriendly take value 1 when it is true, and 0 when it is false.


 /*   [[1,4,1,40,10],
            [2,8,0,50,5],
            [3,8,1,30,4],
            [4,10,0,10,3],
            [5,1,1,15,1]]
            0
            50
            10*/
    public List< Integer > filterRestaurants ( int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance ) {

        List< List< Integer > > list = new ArrayList<>();
        if(veganFriendly ==1) {
            for (int[] restaurant : restaurants) {
                if (restaurant[2] == veganFriendly && maxPrice >= restaurant[3] && maxDistance >= restaurant[4]) {
                    //0- id , 1 - rating
                    List< Integer > l = new ArrayList<>();
                    l.add(restaurant[0]);
                    l.add(restaurant[1]);
                    list.add(l);
                }
            }
        }else{
            for (int[] restaurant : restaurants) {
                if (maxPrice >= restaurant[3] && maxDistance >= restaurant[4]) {
                    //0- id , 1 - rating
                    List< Integer > l = new ArrayList<>();
                    l.add(restaurant[0]);
                    l.add(restaurant[1]);
                    list.add(l);
                }
            }

        }

        Map< Integer, List< Integer > > map = new HashMap<>();
        for (List< Integer > l1 : list) {
            if (map.containsKey(l1.get(1))) {
                List< Integer > m = map.get(l1.get(1));
                m.add(l1.get(0));
                map.put(l1.get(1), m);
            } else {
                List< Integer > m = new ArrayList<>();
                m.add(l1.get(0));
                map.put(l1.get(1), m);

            }
        }
        List<Integer> result = new ArrayList<>();
        map = map.entrySet().stream().sorted(Map.Entry.< Integer, List< Integer > >comparingByKey().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        for(Map.Entry<Integer, List<Integer>> m : map.entrySet()){

            if(m.getValue().size() == 1){
                result.addAll(m.getValue());
            }else{
                List<Integer> l2 = m.getValue();
                Collections.sort(l2, Collections.reverseOrder());

                result.addAll(l2);
            }
        }
        return result;
    }


}

