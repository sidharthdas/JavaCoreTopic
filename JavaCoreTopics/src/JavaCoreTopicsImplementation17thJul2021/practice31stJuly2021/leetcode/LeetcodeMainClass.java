package JavaCoreTopicsImplementation17thJul2021.practice31stJuly2021.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 31/07/21.
 */
public class LeetcodeMainClass {


    public static void main ( String[] args ) {


    }

    public List<Boolean> kidsWithCandies( int[] candies, int extraCandies) {

        int size = candies.length;
        List<Integer> candiesList = new ArrayList<>();
        for(int i : candies){
            candiesList.add(i);
        }
        List<Boolean> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int val = candies[i]+ extraCandies;

            List<Integer> newList = candiesList.stream().filter(x -> val< x).collect(Collectors.toList());
            if(newList.size() != 0){
                list.add(false);
            }else{
                list.add(true);
            }

        }
return list;
    }
}
