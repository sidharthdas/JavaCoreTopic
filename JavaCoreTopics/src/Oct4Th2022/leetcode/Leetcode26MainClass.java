package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode26MainClass {

    public static void main(String[] args) {
    }

    public String sortVowels(String s) {
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

    public int maxCount(int[] banned, int n, int maxSum) {
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
