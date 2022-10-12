package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  11/10/22
 */
public class LeetcodeMain11 {
    public static void main(String[] args) {

       /* FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)*/

        //System.out.println(simplifiedFractions(2));

        /*
         * dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
         * */

        System.out.println(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));

    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        List<String> l = new ArrayList<>();
        String sentenceArr[] = sentence.split(" ");
        String mainSen = "";
        int count = 0;
        int len = dictionary.size();
        for (String s1 : sentenceArr) {
            for (int i = 0; i < len; i++) {
                int s1Len = s1.length();
                String s2 = dictionary.get(i);
                int s2Len = s2.length();

                if (s2Len <= s1Len) {
                    if (s1.substring(0, s2Len).equals(s2)) {
                        l.add(s2);
                        //mainSen += s2 + " ";
                    }
                }
                count ++;
            }
            if(l.isEmpty()){
                mainSen += s1 + " ";
            }else{
                if(l.size() == 1){
                    mainSen += l.get(0) + " ";
                    l = new ArrayList<>();
                }else{
                    Collections.sort(l, (x, y) -> x.length()-y.length());
                    mainSen += l.get(0) + " ";
                    l = new ArrayList<>();
                }
            }
        }

        return mainSen.trim();
    }




            /*for (String s2 : dictionary) {
                int s1Len = s1.length();
                int s2Len = s2.length();
                if (s2Len <= s1Len) {
                    if (s1.substring(0, s2Len).equals(s2)) {
                        mainSen += s2 + " ";
                        count = 0;
                        break;
                    }
                }
                if (count == len - 1) {
                    if (s2Len <= s1Len) {
                        if (s1.substring(0, s2Len).equals(s2)) {
                            mainSen += s2 + " ";
                            count = 0;
                            break;
                        }else{
                            mainSen += s1 + " ";
                            count = 0;
                        }
                    } else {
                        mainSen += s1 + " ";
                        count = 0;
                    }
                }
                count += 1;
            }

        }
        return mainSen.trim();
    }*/

    public List<String> simplifiedFractions(int n) {
        List<String> l = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            for (int j = i + 1; j <= n; j++) {
                if (i % j != 0) {
                    if (i == 1) {
                        l.add(i + "/" + j);
                    } else if (simplify(i, j)) {
                        l.add(i + "/" + j);
                    }
                }
            }
        }
        return l;
    }

    private boolean simplify(int first, int sec) {
        int i = 2;
        boolean flag = true;
        while (i <= first) {
            if (first % i == 0 && sec % i == 0) {
                flag = false;
                break;
            }
            i++;
        }

        return flag;
    }

    public boolean canConstruct(String s, int k) {

        int len = s.length();

        if (len < k) {
            return false;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");

        for (String s1 : srr) {
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + 1);
            } else {
                map.put(s1, 1);
            }
        }

        int sol = 0;

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 != 0) {
                sol += 1;
            }
        }
        return sol >= k;
    }

    public static String removeOccurrences(String s, String part) {
        if (!s.contains(part)) {
            return s;
        }
        s = s.replaceFirst(part, "");
        return removeOccurrences(s, part);
    }

    public int largestPerimeter(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().sorted().toList();
        int len = nums.length;
        int a = l.get(len - 1);
        int b = l.get(len - 2);
        int c = l.get(len - 3);

        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            return a + b + c;
        }
        return 0;
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] srr = domain.split(" ");
            int times = Integer.parseInt(srr[0]);
            if (map.containsKey(srr[1])) {
                map.put(srr[1], map.get(srr[1]) + times);
            } else {
                map.put(srr[1], times);
            }
            List<String> l = new ArrayList<>();
            int lastIndexOfDot = srr[1].lastIndexOf('.');
            int currIndexOfDot = srr[1].indexOf('.');
            while (currIndexOfDot != lastIndexOfDot) {
                String s1 = srr[1].substring(currIndexOfDot + 1);
                if (map.containsKey(s1)) {
                    map.put(s1, map.get(s1) + times);
                } else {
                    map.put(s1, times);
                }

                srr[1] = srr[1].replaceFirst("\\.", "-");
                currIndexOfDot = srr[1].indexOf('.');
            }
            String s1 = srr[1].substring(lastIndexOfDot + 1);
            if (map.containsKey(s1)) {
                map.put(s1, map.get(s1) + times);
            } else {
                map.put(s1, times);
            }
        }

        System.out.println(map);
        map.entrySet().forEach(x -> {
            list.add(x.getValue() + " " + x.getKey());
        });
        return list;
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int currIndex = 0;

        while (list.size() != 1) {
            currIndex += k - 1;
            if (currIndex < list.size()) {
                list.remove(currIndex);
                //currIndex -= 1;
            } else {
                while (currIndex >= list.size()) {
                    currIndex = (currIndex - list.size());
                }
                list.remove(currIndex);
            }
        }
        return list.get(0);
    }
}

class FrontMiddleBackQueue {

    List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(val);
    }

    public void pushMiddle(int val) {
        int middle = list.size() / 2;
        list.add(middle + 1, val);
    }

    public void pushBack(int val) {
        if (list.size() == 0) {
            list.add(val);
        } else {
            list.add(0, val);
        }
    }

    public int popFront() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        int val = list.get(size - 1);
        return list.remove(size - 1);

    }

    public int popMiddle() {
        int middle = list.size() / 2;
        return list.remove(middle + 1);

    }

    public int popBack() {
        return list.remove(0);
    }
}

