package Oct4Th2022.leetcode;

import java.util.*;

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

    public int numUniqueEmails(String[] emails) {
        Map<String , Integer> map = new HashMap<>();

        for(String email : emails){
            String subLocal = email.substring(0, email.indexOf("@") + 1);
            String em = subLocal.replace(".", "");
            if(em.contains("+")){
                String sub = em.substring(em.indexOf("+"), em.indexOf("@"));
                em = em.replace(sub, "");
            }

            String mainEmail = em + email.substring(email.indexOf("@")+1);
            System.out.println(mainEmail);
            map.put(em, map.getOrDefault(mainEmail, 0) + 1);
        }

        return (int) map.entrySet().stream().count();

    }

    public int findMaxK(int[] nums) {
        List<Integer> l1 = Arrays.stream(nums).boxed().toList();
        List<Integer> l = new ArrayList<>();
        for(int x : l1){
            if(x > 0){
                l.add(x);
            }
        }
        Collections.sort(l, Collections.reverseOrder());

        for(int x : l){
            if(l1.contains(-1 * x)){
                return x;
            }
        }
        return -1;
    }

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for(List<String> path :  paths){
            set.add(path.get(1));
        }
        for(List<String> path :  paths){
            set.remove(path.get(0));
        }

        return set.stream().findFirst().get();

    }
    public int[] numberOfLines(int[] widths, String s) {

        int totalWidths = Arrays.stream(widths).boxed().reduce(0, Integer::sum);
        int count = 0;

        return null;
    }

    public int maxDistance(int[] colors) {
        int maxD = Integer.MIN_VALUE;
        int len = colors.length;

        for(int i = 0; i < len; i++){

            for(int j = len - 1; j >= 0; j--){
                if(colors[j] != colors[i]){
                    if((j - i) > maxD){
                        maxD = j-i;
                        break;
                    }
                }
            }
        }
        return maxD;
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
