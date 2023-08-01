package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode26MainClass {

    public static void main(String[] args) {
    }

    public int numSub(String s) {
        return substrings1(s);
    }

    public static int count (String sub){
        String[] subArr = sub.split("");
        return Arrays.stream(subArr).collect(Collectors.toSet()).size() == 1 ? 1 : 0;
    }

    public static int substrings1(String input) {
        List<String> substrings = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substrings.add(input.substring(i, j));
                if (!input.substring(i, j).contains("0")) {
                    map.put(input.substring(i, j), map.getOrDefault(input.substring(i, j), 0) + 1);
                }
            }
        }
        return map.values().stream().reduce(Integer::sum).get();
    }

        public String sortVowels (String s){
            String[] srr = s.split("");

            int len = srr.length;

            List<String> caps = new ArrayList<>();
            List<String> small = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                if (List.of("a", "e", "i", "o", "u").contains(srr[i])) {
                    small.add(srr[i]);
                    srr[i] = "#00#";
                } else if (List.of("A", "E", "I", "O", "U").contains(srr[i])) {
                    caps.add(srr[i]);
                    srr[i] = "#00#";
                }
            }

            Collections.sort(caps);
            Collections.sort(small);
            caps.addAll(small);

            int index = 0;
            for (int i = 0; i < len; i++) {
                if (srr[i].equals("#00#")) {
                    srr[i] = caps.get(index);
                    index++;
                }
            }

            String temp = "";

            for (String s1 : srr) {
                temp += s1;
            }

            return temp;
        }

        public int maxCount ( int[] banned, int n, int maxSum){
            List<Integer> l = Arrays.stream(banned).boxed().toList();
            int count = 0;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (!l.contains(i)) {
                    if (sum + i <= maxSum) {
                        sum += i;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            return count;
        }
    }
