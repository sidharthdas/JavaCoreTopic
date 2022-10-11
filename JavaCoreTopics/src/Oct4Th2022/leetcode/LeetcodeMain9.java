package Oct4Th2022.leetcode;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Sidharth Das
 * created on  10/10/22
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class LeetcodeMain9 {
    public static void main(String[] args) {
        System.out.println(entityParser("&amp;gt;"));
    }

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();

        int len = senders.length;

        for (int i = 0; i < len; i++) {
            String s = senders[i];
            String mes = messages[i];
            int count = mes.split(" ").length;
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + count);
            } else {
                map.put(s, count);
            }
        }

        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).entrySet().stream().findFirst()
                .get().getKey();

    }

    public String longestWord(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int len = words.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int wordi = words[i].length();
                    int wordj = words[j].length();

                    if (wordj <= wordi) {
                        if(words[i].substring(0, wordj).equals(words[j])){
                            count ++;
                        }
                    }
                }
            }

            map.put(words[i], count);
        }
        return map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .findFirst().get().getKey();

    }

    class TimeMap {
        Map<String, Map<Integer, String>> map;

        public TimeMap() {

            map = new HashMap<>();

        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                Map<Integer, String> m = map.get(key);
                m.put(timestamp, value);
                map.put(key, m);
            } else {
                Map<Integer, String> m = new HashMap<>();
                m.put(timestamp, value);
                map.put(key, m);
            }

        }

        public String get(String key, int timestamp) {
            return map.entrySet().stream().filter(x -> x.getKey().equals(key))
                    .findFirst().get().getValue().entrySet().stream()
                    .filter(x -> x.getKey() == timestamp).findFirst().get().getValue();

        }
    }

    public static String entityParser(String text) {
        text = text.replaceAll("&quot;", "-\"-");
        text = text.replaceAll("&apos;", "-\'-");
        text = text.replaceAll("&amp;", "-&-");
        text = text.replaceAll("&gt;", "->-");
        text = text.replaceAll("&lt;", "-<-");
        text = text.replaceAll("&frasl;", "-/-");

        return text.replaceAll("-", "");

        /*Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "\'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        List<String> l = Arrays.asList("&quot;", "&apos;", "&amp;", "&gt;", "&lt;", "&frasl;");

        String mainString = "";

        String[] arr = text.split(" ");
        for (String s : arr) {
            if(l.contains(s)){
                mainString += map.get(s)+ " ";
            }else{
                mainString += s + " ";
            }
        }

        return mainString.trim();*/
    }

    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (((time[i] + time[j]) % 60) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getImportance(List<Employee> employees, int id) {
        int totalImp = 0;

        for (Employee emp : employees) {
            if (emp.id == id) {
                totalImp += emp.importance;

                for (int i : emp.subordinates) {
                    totalImp += getImportance(employees, i);
                }
            }
        }
        return totalImp;
    }

    public void getids(List<Integer> l, Employee emp) {
        if (emp.subordinates.size() == 0) {
            return;
        }


    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        return (nums[len - 1] * nums[len - 2]) - (nums[0] * nums[1]);

    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestedProducts = new ArrayList<>();

        String word[] = searchWord.split("");
        int len = word.length;
        String curr = "";
        for (int i = 0; i < len; i++) {
            curr = curr + word[i];
            suggestedProducts.add(getSearch(curr, products));
        }

        return suggestedProducts;

    }

    private static List<String> getSearch(String sub, String[] pro) {
        List<String> l = new ArrayList<>();
        int subLen = sub.length();
        for (String s : pro) {

            if (s.length() >= subLen && s.substring(0, subLen).equals(sub)) {
                l.add(s);
            }
        }
        List<String> l1 = new ArrayList<>();
        Collections.sort(l);
        int count = 0;
        for (String s1 : l) {
            if (count < 3) {
                l1.add(s1);
                count++;
            } else {
                break;
            }
        }

        return l1;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] arr = new int[len];
        int count = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[i] >= temperatures[j]) {
                    count++;
                } else {
                    arr[i] = count;
                    count = 1;
                    break;
                }
            }
            if (count != 1) {
                arr[i] = 0;
                count = 1;
            }
        }
        return arr;
    }

    public static List<Integer> countSmaller(int[] nums) {
        return null;
    }
}

class CustomStack {

    List<Integer> stack;
    int maxSize;
    int currentSize;

    public CustomStack(int maxSize) {
        stack = new ArrayList<>();
        this.maxSize = maxSize;
        currentSize = 0;
    }

    public void push(int x) {
        if (currentSize < maxSize) {
            stack.add(x);
            currentSize += 1;
        }

        System.out.println("In pUSH" + stack);
    }

    public int pop() {
        if (currentSize == 0) {
            return -1;
        } else {
            currentSize -= 1;
            return stack.remove(currentSize);
        }

    }

    public void increment(int k, int val) {
        if (k >= currentSize) {
            stack = stack.stream().map(x -> x + val).collect(Collectors.toList());
        } else {
            int count = 0;
            int startIndex = currentSize - k;
            List<Integer> l1 = new ArrayList<>();
            for (int i : stack) {
                if (count < k) {
                    l1.add(i + val);
                    i = i + val;
                    count++;
                } else {
                    count++;
                }
            }

            stack = stack.subList(startIndex + 1, currentSize);
            l1.addAll(stack);
            stack = l1;

        }
        System.out.println(stack);
    }
}
