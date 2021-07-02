package JUNE.programmingQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sidharthdas on 02/07/21.
 */
public class LeetCodeLengthOfLongestSubString {

    public static void main ( String[] args ) {
        LeetCodeLengthOfLongestSubString leetCodeLengthOfLongestSubString = new LeetCodeLengthOfLongestSubString();
        System.out.println(leetCodeLengthOfLongestSubString.lengthOfLongestSubstring("au"));
    }


    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        String[] arr = s.split("");
        String s1 = "";
        int size = s.length();
        for(int i = 0; i < size; i++){
            if(s1.contains(arr[i])){
                list.add(s1.length());
                s1 = ""+arr[i];
            }else{
                s1 +=arr[i];
            }
        }


        if(!list.contains(s1.length())){
            list.add(s1.length());
        }

        if(list.isEmpty()){
            return 0;
        }
       // System.out.println(list);
        return list.stream().max(Integer::compare).get();
    }
}
