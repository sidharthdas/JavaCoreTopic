package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Sidharth Das
 * created on  24/10/22
 */
public class LeeetcodeMain15 {

    public static void main(String[] args) {

        // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
        OrderedStream os = new OrderedStream(5);
        os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
        os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
        os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
// Concatentating all the chunks returned:
// [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
// The resulting order is the same as the order above.

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int arrSize = arr.length;
        int totalCount = 0;
        //start point
        List< List<Integer> > list = new ArrayList<>();
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            //group sizes

            for (int grps = startPoint; grps <=arrSize ; grps++) {
                List<Integer> list1 = new ArrayList<>();
                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(arr[j] + " ");
                    list1.add(arr[j]);
                }

                if(list1.size() % 2 != 0){
                    totalCount += list1.stream().reduce(0, Integer::sum);
                }
                list.add(list1);
            }
        }

        return totalCount;
    }
}

class OrderedStream {

    String[] list;
    int pointer;

    public OrderedStream(int n) {
        list = new String[n];
        this.pointer = 0;
    }

    public List<String> insert(int idKey, String value) {
        list[idKey - 1] = value;
        List<String> newList = new ArrayList<>();

        while(pointer < list.length && Objects.nonNull(list[pointer])){
            newList.add(list[pointer]);
            pointer += 1;
        }
        return newList;
    }
}
