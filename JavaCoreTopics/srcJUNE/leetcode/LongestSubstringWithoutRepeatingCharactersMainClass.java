package srcJUNE.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sidharthdas on 05/07/21.
 */
public class LongestSubstringWithoutRepeatingCharactersMainClass {

    public static void main ( String[] args ) {

        LongestSubstringWithoutRepeatingCharactersMainClass longestSubstringWithoutRepeatingCharactersMainClass = new LongestSubstringWithoutRepeatingCharactersMainClass();
        System.out.println(longestSubstringWithoutRepeatingCharactersMainClass.lengthOfLongestSubstring("bwf"));

    }

    public int lengthOfLongestSubstring ( String s ) {
        if (s.length() == 1) {
            return 1;
        }

        if (s.length() == 0) {
            return 0;
        }


        //"abcabcbb"
        int size = s.length();
        List< String > list = new ArrayList<>();
        String str1 = null;
        for (int i = 0; i < size; i++) {
            String str = "" + s.charAt(i);
            for (int j = i + 1; j < size; j++) {
                if (str.contains(s.charAt(j) + "")) {
                    list.add(str);
                    break;
                } else {
                    str += s.charAt(j);
                    str1 = str;
                }

                list.add(str);
            }
        }
        System.out.println(list);
        if (!list.contains(str1)) {
            list.add(str1);

        }
        List< Integer > listNum = new ArrayList<>();

        for (String s1 : list) {
            if (Objects.nonNull(s1)) {
                listNum.add(s1.length());
            }
        }

        int max = list.get(0).length();
        for (int i = 0; i < list.size(); i++) {
            if(Objects.nonNull(list.get(i))) {
                if (list.get(i).length() > max) {
                    max = list.get(i).length();
                }
            }
        }
        // int highest = listNum.stream().max(Integer::compare).get();
        System.out.println(list);
        return max;
    }
}
