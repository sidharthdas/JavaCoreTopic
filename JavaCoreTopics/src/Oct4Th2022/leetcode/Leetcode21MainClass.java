package Oct4Th2022.leetcode;

import override.A;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  17/11/22
 */
public class Leetcode21MainClass {

    public static void main(String[] args) {
       /* ["Bank","deposit","transfer","transfer"]
[[[0]],[1,2],[1,1,1],[1,1,3]]*//*
        Bank bank = new Bank(new long[]{0});
        bank.deposit(1, 2);     // return true, it is valid to deposit $20 to account 5.
        // Account 5 has $10 + $20 = $30.
        bank.transfer(3, 4, 15); // return false, the current balance of account 3 is $10,
        // so it is invalid to transfer $15 from it.
        bank.withdraw(10, 50);   // return false, it is invalid because account 10 does not*/
        //["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
        //[[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]
        /*WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("ab");
        wordDictionary.search("a"); // return False
        wordDictionary.search("a."); // return True
        wordDictionary.search("ab"); // return True
        wordDictionary.search(".a"); // return True
        wordDictionary.search(".b"); // return True
        wordDictionary.search("ab."); // return True
        wordDictionary.search("."); // return True
        wordDictionary.search(".."); // return True*/

/*        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True*/

        //System.out.println(findMiddleIndex(new int[]{1, 1, 1, 1}));
        //System.out.println(checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
        //System.out.println(countsubarraysOddProduct(new int[]{5, 1, 2, 3, 4}));
        //System.out.println(applyOperations(new int[]{1,2,2,1,1,0}));
        //System.out.println(distinctAverages(new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7}));
        //System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        //System.out.println(backspaceCompare("ab##", "c#d#"));
        //System.out.println(countVowelSubstrings("cuaieuouac"));
        //System.out.println(winnerOfGame("AAABABB"));
        //System.out.println(triangularSum(new int[]{1, 2, 3, 4, 5}));
        //[["name","bob"],["age","two"]]
        //System.out.println(evaluate("(a)(b)", Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"))));
        // System.out.println(findAndReplacePattern(new String[]{"badc", "abab", "dddd", "dede", "yyxx"}, "abab"));
        //System.out.println(canBeIncreasing(new int[]{2, 3, 1, 2}));
        //System.out.println(evaluate("(mrvv)(nbh)(tgsq)kmfhpzv(yaj)(f)y(jdjz)(ir)(v)(s)ak(tw)(y)w", Arrays.asList(Arrays.asList("jdvcuhnq", "g"), Arrays.asList("yediraal", "j"), Arrays.asList("vjpwbmgu", "w"), Arrays.asList("xmfaqppl", "r"), Arrays.asList("lembcicy", "p"), Arrays.asList("cyyslclq", "i"), Arrays.asList("mwcqdcwm", "p"), Arrays.asList("mdmbntgd", "h"), Arrays.asList("tpznnnyl", "t"), Arrays.asList("ftczphgc", "v"), Arrays.asList("vadgifxk", "h"), Arrays.asList("czquforc", "n"), Arrays.asList("vigqtimh", "v"), Arrays.asList("jiziptez", "s"), Arrays.asList("pwyelcth", "r"), Arrays.asList("wlkqozyf", "m"), Arrays.asList("xpygxnmj", "d"), Arrays.asList("adozymjw", "f"), Arrays.asList("bjxjtgna", "y"), Arrays.asList("ureemetw", "x"), Arrays.asList("eowfoeei", "q"), Arrays.asList("tw", "ungf"), Arrays.asList("vxoslleo", "g"), Arrays.asList("bawftokw", "b"), Arrays.asList("sfbyblto", "f"), Arrays.asList("lgbqnhpg", "f"), Arrays.asList("oknhudfq", "b"), Arrays.asList("sxiquhyg", "r"), Arrays.asList("cxfwklsn", "w"), Arrays.asList("rprjtget", "h"), Arrays.asList("hgqvkuwj", "p"), Arrays.asList("jdysaybt", "k"), Arrays.asList("rhersdzn", "x"), Arrays.asList("yftngzmr", "p"), Arrays.asList("arubuguk", "b"), Arrays.asList("xloxgmoz", "c"), Arrays.asList("jxuhxkkg", "b"), Arrays.asList("upsfbqgv", "h"), Arrays.asList("ehgttwer", "i"), Arrays.asList("fvspnzrs", "w"), Arrays.asList("nlhovrmk", "v"), Arrays.asList("jtiwewui", "l"), Arrays.asList("izsqicwu", "h"), Arrays.asList("pnjlmylt", "g"), Arrays.asList("f", "vava"), Arrays.asList("fsniyzec", "g"), Arrays.asList("xerbzwek", "v"), Arrays.asList("wpmfveht", "d"), Arrays.asList("aeynlizp", "b"), Arrays.asList("y", "rrkv"), Arrays.asList("mlajgsll", "u"), Arrays.asList("mdjwnyhh", "q"), Arrays.asList("fuubthmi", "i"), Arrays.asList("zytszqhy", "g"), Arrays.asList("nautvnmh", "q"), Arrays.asList("snsiaaze", "y"), Arrays.asList("guimbybe", "x"), Arrays.asList("gojbikaw", "v"), Arrays.asList("gbjvveec", "w"))));
        //System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        //System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        //System.out.println(distanceBetweenBusStops(new int[]{3,6,7,2,9,10,7,16,11}, 6, 2));
        //Map<String, String> m = new HashMap<>();

        /*List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 120000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "mkyong.com", 1));

       *//* Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        System.out.println("Result 1 : " + result1);*//**/
        System.out.println(5^2);
        findArray(new int[]{5,2,0,3,1});

    }

    public static int[] findArray(int[] pref) {
        int len = pref.length;
        int[] finalArr = new int[len];

        for(int i = len - 1; i>0; i--){

            finalArr[i] = pref[i] ^ pref[i-1];
        }
        finalArr[0] = pref[0];
        return finalArr;
    }

    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        if(n == 1) return 1;
        if(n == 0) return 0;
        arr[0] = 0;
        arr[1] = 1;
        int max = 0;

        for(int i = 2; i <=n; i++){
            if(i % 2 == 0){
                arr[i] = arr[i / 2];
            }else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }

            max = Math.max(arr[i], max);
        }

        return max;
    }

    public int maximumValue(String[] strs) {
        List<Integer> l = new ArrayList<>();
        for(String s : strs){
            if(s.matches("[0-9]+") ){
                l.add(Integer.parseInt(s));
            }else{
                l.add(s.length());
            }
        }

        return l.stream().sorted(Comparator.reverseOrder()).findFirst().get();
    }


    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> l = new ArrayList<>();
        l.add(nums[len - 1]);
        int currIndex = len - 2;
        while(l.size() != len) {
            int sum = 0;
            int currListSum = l.stream().reduce(0, Integer::sum);
            for (int i = currIndex; i >= 0; i--) {
                sum+= nums[i];
                if(sum > currListSum){
                    break;
                }
            }
            if(sum < currListSum){
                break;
            }
            l.add(nums[currIndex]);
            currIndex -= 1;
        }
        return l;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0, maxi = nums[0];

        for(int i = 0; i < len; i++){
            sum += nums[i];
            maxi = Math.max(maxi, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int len = distance.length;
        int forward = 0;
        int backward = 0;
        int current = start;
        while(current != destination){
            forward += distance[current];
            if(current == len - 1){
                current = 0;
            }else {
                current++;
            }
        }
        int backCurrent = start;

        for(int i = start; ; i--){
            if(i - 1 < 0){
                i = len -1;
            }
            backward += distance[i];
            if(i == destination){
                break;
            }
        }
        /*while(backCurrent != destination ){
            backward += distance[backCurrent];
            if(backCurrent == 0){
                backCurrent = len - 1;
            }else {
                backCurrent--;
            }
        }*/

        //backward = backward - distance[start];

        return backward > forward ? forward : backward;

    }

    public void duplicateZeros(int[] arr) {
        int len = arr.length;

        for(int i = 0; i < len ; i++){
            if(arr[i] == 0){
                if(i + 1 < len){
                    move(i+1, arr);
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }

    private void move(int index, int[] arr){
        int prev = arr[index];

        for(int i = index + 1; i <  arr.length; i++){
            int temp = arr[i];
            arr[i] = prev;
            prev = temp;
        }
    }

    public static String removeDuplicates(String s, int k) {
        while (true) {
            int len = s.length();
            String[] srr = s.split("");
            String s1 = "";
            int count = 0;
            String subStr = "";
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    s1 = srr[0];
                    count++;
                    subStr = srr[0];
                } else {
                    if (s1.equals(srr[i])) {
                        subStr += s1;
                        count++;
                    } else {
                        s1 = srr[i];
                        count = 1;
                        subStr = srr[i];
                    }

                    if (count == k) {
                        s = s.replaceFirst(subStr, "");
                        break;
                    }
                }
            }

            if (count < k) {
                break;
            }
        }
        System.out.println(s);
        return s;
    }

    public static String decodeString(String s) {
        int len = s.length();
        while(s.contains("[")){
            int lastIndex = s.lastIndexOf("[");
            String nums = "";
            int curr = lastIndex - 1;
            while(curr >= 0 && Arrays.asList("1","2","3","4","5","6","7","8","9","0").contains(String.valueOf(s.charAt(curr)))
                 ){
                nums = s.charAt(curr) + nums;
                curr --;
            }
            len = s.length();
            StringBuilder sb = new StringBuilder();
            for(int i = lastIndex; i < len; i++){
                sb.append(s.charAt(i));
                if(s.charAt(i)== ']'){
                    break;
                }
            }
            int times = Integer.parseInt(nums);
            int sbLen = sb.length();
            String s1 = sb.toString().substring(1, sbLen - 1);
            String sb1 = "";
            while(times != 0){
                sb1 += s1;
                times--;

            }
            s = s.replace(nums+sb.toString(), sb1);
        }
        return s;
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> l : knowledge) {
            map.put(l.get(0), l.get(1));
        }

        while (s.contains("(")) {
            int startIndex = s.indexOf("(");
            int endIndex = s.indexOf(")");
            String sub = s.substring(startIndex, endIndex + 1);
            String word = sub.substring(1, sub.length() - 1);

            if(map.containsKey(word)){
                s = s.replaceFirst("\\("+s.substring(startIndex+1, endIndex)+"\\)" , map.get(word));

            }else{
                s = s.replaceFirst("\\("+s.substring(startIndex+1, endIndex)+"\\)" , "?");
                /*s = s.replace(s.substring(startIndex + 1, endIndex), "?");
                s = s.replaceFirst("\\(","");
                s = s.replaceFirst("\\)","");*/
            }
        }

        return s;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushSize = pushed.length;
        System.out.println(pushSize);
        return false;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l = new ArrayList<>();
        l.addAll(Arrays.stream(nums).boxed().filter(x -> x < pivot).toList());
        l.addAll(Arrays.stream(nums).boxed().filter(x -> x == pivot).toList());
        l.addAll(Arrays.stream(nums).boxed().filter(x -> x > pivot).toList());

        return l.stream().mapToInt(Integer::new).toArray();
    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> l = new ArrayList<>();
        Arrays.sort(folder);
        int len = folder.length;
        String curr = "";
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                l.add(folder[0]);
                curr = folder[0];
            } else {
                if (!folder[i].startsWith(curr + "/")) {
                    l.add(folder[i]);
                    curr = folder[i];
                }
            }
        }

        return l;
    }

    public static boolean canBeIncreasing(int[] nums) {
        String s = "";

        int len = nums.length;
        int prev = nums[0];
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (prev < nums[i]) {
                prev = nums[i];
            } else {
                if (prev >= nums[i] && i - 2 > 0) {

                    prev = nums[i - 2];
                } else {

                    prev = nums[0];

                }
                count += 1;
            }

            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> pat(String word) {
        List<Integer> l = new ArrayList<>();
        String[] s = word.split("");
        int count = 0;
        int len = word.length();
        String currentString = "";
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                currentString = s[i];
                count = 1;
            } else {
                if (s[i].equals(currentString)) {
                    count++;
                } else {
                    l.add(count);
                    count = 1;
                    currentString = s[i];
                }
            }
        }

        l.add(count);
        return l;
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> l = new ArrayList<>();
        List<Integer> partL = pat(pattern);
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] s = pattern.split("");
        for (String s1 : s) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        for (String word : words) {
            boolean flag = true;
            List<Integer> l1 = pat(word);
            if (partL.size() == l1.size()) {
                Iterator<Integer> targetIt = partL.iterator();
                for (int obj : l1) {
                    if (!(obj == targetIt.next())) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    l.add(word);
                }
            }


        }
        return l;
    }


    public int numTeams(int[] rating) {
        int count = 0;

        int len = rating.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int triangularSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (list.size() != 1) {
            List<Integer> temp = new ArrayList<>();

            int len = list.size();

            for (int i = 0; i < len - 1; i++) {
                temp.add((list.get(i) + list.get(i + 1)) % 10);
            }

            list = new ArrayList<>();
            list.addAll(temp);
        }

        return list.get(0);

    }

    public static boolean winnerOfGame(String colors) {
        System.out.println(colors.indexOf("AAA"));
        int c = 0;
        while (true) {
            if (c == 0) {
                c = 1;
                if (colors.contains("AAA")) {
                    colors = colors.replaceFirst("AAA", "AA");
                } else {
                    return false;
                }
            } else {
                c = 0;
                if (colors.contains("BBB")) {
                    colors = colors.replaceFirst("BBB", "BB");
                } else {
                    return true;
                }

            }
        }
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int lenQueries = queries.length;
        int lenWords = words.length;
        int[] finalArr = new int[lenQueries];
        int[] intQueries = new int[lenQueries];
        int[] intWords = new int[lenWords];

        for (int i = 0; i < lenQueries; i++) {
            intQueries[i] = countSmallestLetterFrequency(queries[i]);
        }

        for (int i = 0; i < lenWords; i++) {
            intWords[i] = countSmallestLetterFrequency(words[i]);
        }

        for (int i = 0; i < lenQueries; i++) {
            int j = i;
            int g = (int) Arrays.stream(intWords).boxed().filter(x -> x > intQueries[j]).count();
            finalArr[i] = g;
        }

        return finalArr;
    }

    private int countSmallestLetterFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (char c1 : c) {
            map.put(c1, map.getOrDefault(c1, 0) + 1);
        }

        return map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByKey())
                .findFirst().get().getValue();
    }

    public static int countVowelSubstrings(String word) {
        if (word.length() < 5) return 0;
        Set<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        char[] crr = word.toCharArray();
        int size = word.length();
        for (int len = 1; len <= size; len++) {
            // Pick ending point
            for (int i = 0; i <= size - len; i++) {
                //  Print characters from current
                // starting point to current ending
                // point.
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    sb.append(crr[k]);
                }
                String s1 = sb.toString();
                sb = new StringBuilder();
                if (s1.length() >= 5 && s1.contains("a") && s1.contains("e") && s1.contains("i") && s1.contains("o") && s1.contains("u")) {
                    set.add(s1);
                }
            }
        }
        return set.size();
    }

    public static boolean backspaceCompare(String s, String t) {

        while (s.contains("#")) {
            if (s.indexOf('#') == 0) break;
            int index = s.lastIndexOf('#');
            String s1 = s.charAt(index - 1) + "#";
            s = s.replaceFirst(s1, "");
        }

        while (t.contains("#")) {
            if (s.indexOf('#') == 0) break;
            int index = t.indexOf('#');
            String s1 = t.charAt(index - 1) + "#";
            t = t.replaceFirst(s1, "");
        }

        return s.equals(t);

    }

    public String modifyString(String s) {
        if (s.length() == 1 && s.equals("?")) return "a";
        int len = s.length();
        while (s.contains("?")) {
            int index = s.indexOf('?');
            if (index == 0 && index < len) {
                char a = 'a';
                for (char i = 'a'; i <= 'z'; i++) {
                    String s1 = i + "";
                    if (!String.valueOf(s.charAt(index + 1)).equals(s1)) {
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }
            } else if (index > 0 && index < len - 1) {
                char a = 'a';
                for (char i = 'a'; i <= 'z'; i++) {
                    String s1 = i + "";
                    if (!String.valueOf(s.charAt(index + 1)).equals(s1) && !String.valueOf(s.charAt(index - 1)).equals(s1)) {
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }
            } else {
                char a = 'a';
                for (char i = 'a'; i <= 'z'; i++) {
                    String s1 = i + "";
                    if (!String.valueOf(s.charAt(index - 1)).equals(s1)) {
                        s = s.replaceFirst("\\?", s1);
                        break;
                    }
                }

            }
        }
        return s;
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        int event1StartHH = Integer.parseInt(event1[0].split(":")[0]);
        int event1StartMM = Integer.parseInt(event1[0].split(":")[1]);
        int event1EndHH = Integer.parseInt(event1[1].split(":")[0]);
        int event1EndMM = Integer.parseInt(event1[1].split(":")[1]);

        int event2StartHH = Integer.parseInt(event2[0].split(":")[0]);
        int event2StartMM = Integer.parseInt(event2[0].split(":")[1]);
        int event2EndHH = Integer.parseInt(event2[1].split(":")[0]);
        int event2EndMM = Integer.parseInt(event2[1].split(":")[1]);

        if (event2StartHH > event1EndHH) {
            return false;
        } else {
            if (event2StartHH == event1EndHH) {
                if (event2StartMM > event1EndMM) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (event2StartHH < event1StartHH && event2EndHH < event1StartHH) {
                    return false;
                } else if (event2StartHH == event1StartHH || event2EndHH == event1StartHH) {
                    if (event2StartMM < event1StartMM && event2EndMM < event1StartMM) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() <= str2.length()) {
            StringBuilder sb = new StringBuilder("");
            int len = str1.length();
            int index = 0;
            while (true) {
                if (index < len && !sb.toString().contains(str1.substring(index, index + 1))) {
                    sb.append(str1.substring(index, index + 1));
                    index++;
                } else {
                    break;
                }
            }
            int newLen = sb.length();
            while (true) {
                if (sb.toString().equals(str2.substring(0, newLen))) {
                    return sb.toString();
                } else {
                    newLen--;
                    if (newLen == 0) {
                        break;
                    }
                }

            }

            return "";

        } else {
            StringBuilder sb = new StringBuilder("");
            int len = str2.length();
            int index = 0;
            while (true) {
                if (index < len && !sb.toString().contains(str2.substring(index, index + 1))) {
                    sb.append(str2.substring(index, index + 1));
                    index++;
                } else {
                    break;
                }
            }
            int newLen = sb.length();
            while (true) {
                if (sb.toString().equals(str1.substring(0, newLen))) {
                    return sb.toString();
                } else {

                    if (newLen == 0) {
                        break;
                    }
                    newLen--;
                }

            }

            return "";
        }

    }

    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "").replaceAll("-", "");
        if (number.length() == 2 || number.length() == 3) {
            return number;
        }
        if (number.length() == 4) {
            return number.substring(0, 2) + "-" + number.substring(2);
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            if (number.length() > 4) {
                sb.append(number.substring(0, 3)).append("-");
                number = number.substring(3);
            } else if (number.length() == 4) {
                sb.append(number.substring(0, 2)).append("-").append(number.substring(2));
                break;
            } else {
                sb.append(number);
                break;
            }

        }
        return sb.toString();
    }

    public int minDeletionSize(String[] strs) {
        int count = 0;
        int len = strs.length;
        int wordLen = strs[0].length();
        char prevChar = 0;
        for (int i = 0; i < wordLen; i++) {
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    prevChar = strs[j].charAt(i);
                } else {
                    if (prevChar > strs[j].charAt(i)) {
                        count++;
                        break;
                    } else {
                        prevChar = strs[j].charAt(i);
                    }
                }
            }
        }
        return count;
    }

    public String tictactoe(int[][] moves) {
        System.out.println();
        int len = moves.length;
        if (len == 5) {
            return "A";
        }
        //[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
        int[][] tictac = new int[3][3];
        int count = 0;
        for (int[] t : tictac) {
            if (count % 2 != 0) {
                tictac[t[0]][t[1]] = 10;
                count++;
            } else {
                count++;
            }
        }

        if (tictac[0][0] == 10 && tictac[0][1] == 10 && tictac[0][2] == 10) {
            return "B";
        } else if (tictac[1][0] == 10 && tictac[1][1] == 10 && tictac[1][2] == 10) {
            return "B";
        } else if (tictac[2][0] == 10 && tictac[2][1] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][0] == 10 && tictac[1][0] == 10 && tictac[2][0] == 10) {
            return "B";
        } else if (tictac[0][1] == 10 && tictac[1][1] == 10 && tictac[2][1] == 10) {
            return "B";
        } else if (tictac[0][2] == 10 && tictac[1][2] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][0] == 10 && tictac[1][1] == 10 && tictac[2][2] == 10) {
            return "B";
        } else if (tictac[0][2] == 10 && tictac[1][1] == 10 && tictac[2][0] == 10) {
            return "B";
        } else {
            return "DRAW";
        }


    }

    public boolean kLengthApart(int[] nums, int k) {

        int len = nums.length;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                l.add(i);
            }
        }

        int lenL = l.size();
        for (int i = 0; i < lenL - 1; i++) {
            if (!(l.get(i + 1) - l.get(i) >= k + 1)) {
                return false;
            }
        }
        return true;
    }

    public int averageValue(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().filter(x -> x % 2 == 0 && x % 6 == 0).collect(Collectors.toList());
        int len = l.size();
        if (len == 0) {
            return 0;
        }
        return l.stream().reduce(0, Integer::sum) / len;
    }

    public static int distinctAverages(int[] nums) {

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<Double> set = new TreeSet<>();

        while (list.size() != 0) {
            list = list.stream().sorted().collect(Collectors.toList());
            int max = list.get(list.size() - 1);
            int min = list.get(0);
            list.remove(new Integer(max));
            list.remove(new Integer(min));

            double d = (double) (max + min) / 2;
            set.add(d);
        }

        return set.size();
    }

    public static int[] applyOperations(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
                i = i + 2;
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (i != 0) {
                list.add(i);
            }
        }

        int zeroCount = (int) Arrays.stream(nums).filter(x -> x == 0).count();
        while (zeroCount != 0) {
            list.add(0);
            zeroCount--;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public static int countsubarraysOddProduct(int[] arr) {
        List<Integer> l = Arrays.stream(arr).boxed().filter(x -> x % 2 != 0).toList();
        int n = l.size();
        System.out.println(l);
        for (int i = 0; i < n; i++) {
            // Pick ending point
            for (int j = i; j < n; j++) {
                // Print subarray between current starting
                // and ending points
                for (int k = i; k <= j; k++)
                    System.out.print(l.get(k) + " ");
            }
            System.out.println();
        }
        return 0;
    }


    public static boolean checkXMatrix(int[][] grid) {
        int len = grid.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((i == j) || (i == len - 1 - j)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }

                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }

        return true;

    }


    public static int findMiddleIndex(int[] nums) {
        int len = nums.length;

        if (len == 2) {
            if (nums[0] == 0) {
                return 1;
            } else if (nums[1] == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        int mid = (len - 1) / 2;

        while (true) {
            int left = 0;
            for (int i = 0; i < mid; i++) {
                left += nums[i];
            }

            int right = 0;
            for (int i = mid + 1; i < len; i++) {
                right += nums[i];
            }

            if (mid == 0 && right == 0) {
                return mid;
            }
            if (mid == len - 1 && left == 0) {
                return mid;
            }

            if (mid == 0 && right != left) {
                break;
            }
            if (mid == len - 1 && right != left) {
                break;
            }

            if (left > right) {
                mid = mid - 1;
            } else if (left < right) {
                mid = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public String rankTeams(String[] votes) {
        StringBuilder sb = new StringBuilder();
        int votesLen = votes.length;
        int partLen = votes[0].length();

        for (int i = 0; i < partLen; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (String vote : votes) {
                map.put(vote.charAt(i) + "", map.getOrDefault(vote.charAt(i) + "", 0) + 1);
            }
            int high = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .findFirst().get().getValue();

            Set<String> set = map.entrySet().stream().filter(x -> x.getValue() == high).
                    sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new)).keySet();

            for (String s : set) {
                if (!sb.toString().contains(s)) {
                    sb.append(s);
                    break;
                }
            }
        }
        return sb.toString();
    }


    public int countNicePairs1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int i = num - rev(num);

            if (map.containsKey(i)) {
                count += 1;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    //The condition can be rearranged to (nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j])).
    //0 <= i < j < nums.length
    public int countNicePairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j]))) {
                    count++;
                }
            }
        }
        return count;
    }

    private int rev(int n) {
        int reverse = 0;
        while (n != 0) {
            int remainder = n % 10;
            reverse = reverse * 10 + remainder;
            n = n / 10;
        }

        return reverse;
    }

    public String reorganizeString(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] srr = s.split("");

        for (String s1 : srr) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        Set<String> set = map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).keySet();

        StringBuilder sb = new StringBuilder();
        while (map.size() > 0) {
            for (String se1 : set) {
                if (map.containsKey(se1)) {
                    sb.append(se1);
                    if (map.get(se1) == 1) {
                        map.remove(se1);
                    } else {
                        map.put(se1, map.get(se1) - 1);
                    }
                }
            }
        }

        if (checkString(sb.toString())) {
            return sb.toString();
        }
        return "";
    }

    private boolean checkString(String s) {
        int len = s.length();
        String[] srr = s.split("");
        for (int i = 0; i < len - 1; i++) {
            if (srr[i].equals(srr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public String bestHand(int[] ranks, char[] suits) {

        Map<Integer, Integer> ranksMap = new HashMap<>();
        Map<Character, Integer> suitsMap = new HashMap<>();

        for (int rank : ranks) {
            ranksMap.put(rank, ranksMap.getOrDefault(rank, 0) + 1);
        }

        for (char suit : suits) {
            suitsMap.put(suit, ranksMap.getOrDefault(suit, 0) + 1);
        }

        if (suitsMap.size() == 1) {
            return "Flush";
        } else {
            int val = ranksMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .findFirst().get().getValue();

            if (val >= 3) {
                return "Three of a Kind";
            } else if (val == 2) {
                return "Pair";
            } else {
                return "High Card";
            }
        }

    }

    public int mostFrequent(int[] nums, int key) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }

        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .findFirst().get().getKey();

    }

    public boolean makeEqual(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            String[] s1 = s.split("");
            for (String s2 : s1) {
                map.put(s2, map.getOrDefault(s2, 0) + 1);
            }
        }

        int len = words.length;

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (m.getValue() % len != 0) {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeNodes(ListNode head) {
        LinkedList1 ll = new LinkedList1();
        int sum = 0;
        int zeroCount = 0;
        while (head.next != null) {
            if (zeroCount == 2) {
                ll = ll.insertAtEnd(ll, sum);
                zeroCount = 1;
                sum = 0 + head.val;
            } else if (head.val == 0) {
                zeroCount++;
            } else {
                sum += head.val;
            }

            head = head.next;
        }
        return ll.head;

    }

    public List<Boolean> camelMatch1(String[] queries, String pattern) {
        List<String> alpha = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        String[] arr = pattern.split("");
        int len = pattern.length();
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 1; i < len; i++) {
            if (alpha.contains(arr[i])) {
                l.add(sb.toString());
                sb = new StringBuilder(arr[i]);
            } else {
                sb.append(arr[i]);
            }
        }
        l.add(sb.toString());
        List<Boolean> finalList = new ArrayList<>();

        for (String s : queries) {
            boolean flag = true;
            for (String s1 : l) {
                if (!s.contains(s1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                finalList.add(true);
            } else {
                finalList.add(false);
            }
        }

        return finalList;
    }

    public int specialArray(int[] nums) {
        int len = nums.length;

        for (int x = len; x >= 0; x--) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        System.out.println();
        return -1;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> l = new ArrayList<>();
        for (String query : queries) {
            query = query.replaceAll("[^a-z]", "");
            if (pattern.equals(query)) {
                l.add(true);
            } else {
                l.add(false);
            }
        }

        return l;
    }


    public int maxProduct(String[] words) {
        Arrays.sort(words, (x1, x2) -> x1.length() - x2.length());
        int len = words.length;

        return words[len - 1].length() * words[len - 2].length();

    }
}

class Bank {

    Map<Integer, Long> map;

    public Bank(long[] balance) {
        map = new HashMap<>();
        int len = balance.length;
        for (int i = 0; i < len; i++) {
            map.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {

        if (map.containsKey(account1) && map.containsKey(account2)) {
            if (account2 == account1) return true;
            long bal1 = map.get(account1);
            long bal2 = map.get(account2);
            if (bal1 >= money) {
                map.put(account1, bal1 - money);
                map.put(account2, bal2 + money);
                return true;
            }
        }

        return false;

    }

    public boolean deposit(int account, long money) {
        if (map.containsKey(account)) {
            map.put(account, map.get(account) + money);
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if (map.containsKey(account)) {
            long mon = map.get(account);
            if (money <= mon) {
                map.put(account, mon - money);
                return true;
            }
        }

        return false;
    }
}


class LinkedList1 {

    ListNode head = null;

    public LinkedList1 insertAtEnd(LinkedList1 l, int data) {
        ListNode node = new ListNode();
        node.val = data;

        if (l.head == null) {
            l.head = node;
        } else {
            ListNode currNode = l.head;

            while (currNode.next != null) {
                currNode = currNode.next;
            }

            currNode.next = node;
        }

        return l;
    }


}

class WordDictionary {
    Map<String, Boolean> map;

    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        map.put(word, true);
    }

    public boolean search(String word) {

        String[] w = word.split("");
        int len = w.length;
        List<String> list = map.keySet().stream().filter(x -> x.length() == len).toList();
        for (String w1 : list) {
            boolean flag = true;
            if (w1.length() == w.length) {


                String[] w1Arr = w1.split("");
                for (int i = 0; i < len; i++) {
                    if (!w[i].equals(".")) {
                        if (!w[i].equals(w1Arr[i])) {
                            flag = false;
                            break;
                        }
                    }
                }
            } else {
                flag = false;
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}

class Trie {

    Map<String, Boolean> map;

    public Trie() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        map.put(word, true);
    }

    public boolean search(String word) {
        return map.containsKey(word);
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        List<String> l = map.keySet().stream().filter(x -> x.length() >= len).toList();

        for (String s : l) {
            if (prefix.equals(s.substring(0, len))) {
                return true;
            }
        }

        return false;
    }
}
 class Hosting {

    private int Id;
    private String name;
    private long websites;

    public Hosting(int id, String name, long websites) {
        Id = id;
        this.name = name;
        this.websites = websites;
    }

    //getters, setters and toString()
}
