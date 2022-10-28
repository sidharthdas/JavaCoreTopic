package Oct4Th2022.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  26/10/22
 */
public class LeetcodeMainClass16 {
    public static void main(String[] args) {
        /*List<Integer> l = Arrays.asList(1,23,4,5,6,78,9,-1,0);
        l.stream().filter(LeetcodeMainClass16::compare).toList();*/
        //licenseKeyFormatting("2-5g-3-J", 2);
        //5 ^ 7 = 2
        /*System.out.println(5 ^ 7);
        System.out.println(5  2);*/

        /*CombinationIterator itr = new CombinationIterator("abc", 2);
        itr.next();    // return "ab"
        itr.hasNext(); // return True
        itr.next();    // return "ac"
        itr.hasNext(); // return True
        itr.next();    // return "bc"
        itr.hasNext(); // return False*/
        /*int[] arr = new int[]{1,2,3,4,56,78,9};
        int[] newArray = Arrays.copyOfRange(arr, 7, 7);
        System.out.println(Arrays.stream(newArray).boxed().toList());*/

       /* StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
        streamChecker.query("a"); // return False
        streamChecker.query("b"); // return False
        streamChecker.query("c"); // return False
        streamChecker.query("d"); // return True, because 'cd' is in the wordlist
        streamChecker.query("e"); // return False
        streamChecker.query("f"); // return True, because 'f' is in the wordlist
        streamChecker.query("g"); // return False
        streamChecker.query("h"); // return False
        streamChecker.query("i"); // return False
        streamChecker.query("j"); // return False
        streamChecker.query("k"); // return False
        streamChecker.query("l"); // return True, because 'kl' is in the wordlist*/
        countQuadruplets_1(new int[]{1, 2, 3, 6});
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> minimumAbsDifference = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length;
        int minDifference = Integer.MAX_VALUE;

        for(int i = 0; i < len; i++){
            int diff = arr[i + 1] - arr[i];
            if(diff < minDifference){
                minimumAbsDifference.clear();
                minDifference = diff;
                minimumAbsDifference.add(List.of(arr[i], arr[i + 1]));
            }else if(minDifference == diff){
                minimumAbsDifference.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return minimumAbsDifference;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> l = map.get(groupSizes[i]);
                l.add(i);
                map.put(groupSizes[i], l);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(groupSizes[i], l);
            }
        }
        List<List<Integer>> groupThePeople = new ArrayList<>();

        map.entrySet().forEach(x -> {
            List<Integer> l = new ArrayList<>();
            for(int i : x.getValue()){
                if(l.size()<= x.getKey()){
                    l.add(i);
                }else{
                    groupThePeople.add(l);
                    l = new ArrayList<>();
                }
            }
            groupThePeople.add(l);
        });

        return groupThePeople;
    }

    public static int countQuadruplets_1(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i + 2; k < len; k++) {
                    for (int l = i + 3; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            res += 1;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int nextBeautifulNumber(int n) {
        int[] beautifulNumbers = {0, 1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666, 1224444};
        int position = Arrays.binarySearch(beautifulNumbers, n);
        if (position >= 0) {
            return beautifulNumbers[position + 1];
        } else return 0;
    }

    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int len = arr.length;
        List<Integer> l = new ArrayList<>();
        int current = arr[0];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (current < arr[i]) {

            }
        }
        return 0;
    }


    public boolean sumOfNumberAndReverse(int num) {
        int half = num / 2;

        for (int i = 1; i <= half; i++) {
            if (i + reverse(i) == num) {
                return true;
            }
        }

        return false;
    }

    private int reverse1(int number) {
        int reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }

        return reverse;
    }

    public int countTriples(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double c = (int) Math.sqrt(j * j + i * i);
                if (c == (int) c && c < n) {
                    count++;
                }
            }
        }
        return count;
    }


    public static List<Integer> countSmaller(int[] nums) {
        int count = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            int finalI = i;
            list.add((int) Arrays.stream(Arrays.copyOfRange(nums, i, len)).boxed().filter(x -> x < nums[finalI]).count());
        }
        return list;
    }

    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int[] i : operations) {
            int index = map.get(i[0]);
            nums[index] = i[1];
            map.remove(i[0]);
            map.put(i[1], index);
        }
        return nums;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> wordSubsets = new ArrayList<>();

        for (String s : words1) {
            boolean flag = true;
            for (String s1 : words2) {
                if (!s.contains(s1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                wordSubsets.add(s);
            }
        }
        return wordSubsets;
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<Integer> val = map.values().stream().toList();
        int count = 0;
        for (int v : val) {
            if (v == 1) return -1;
            count = (v + 2) / 3;
        }

        return count;
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> l = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)).values().stream().collect(Collectors.toList());

        while (k > 0) {
            if (l.get(0) > k) {
                return l.size();
            } else if (l.get(0) == k) {
                return l.size() - 1;
            } else {
                int i = l.get(0);
                k = k - i;
                l.remove(0);
            }
        }
        return -1;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(reverse(i));
            set.add(i);
        }

        return set.size();
    }

    private int reverse(int number) {
        int reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }

        return reverse;
    }

    public static String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-", "").toUpperCase();
        int len = s.length();
        String finalString = "";
        int count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (count < k) {
                finalString = s.charAt(i) + finalString;
                count++;
            } else {
                count = 1;
                finalString = s.charAt(i) + "-" + finalString;


            }
        }
        return finalString;
    }

    public static boolean compare(int x) {
        return x >= 0;
    }

    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        char[] movesArr = moves.toCharArray();

        for (char c : movesArr) {
            if (c == 'U') x++;
            else if (c == 'D') x--;
            else if (c == 'R') y++;
            else if (c == 'L') y--;
        }

        return x == 0 && y == 0;

    }

    public int countAsterisks(String s) {
        char[] crr = s.toCharArray();
        boolean flag = true;
        int count = 0;

        for (char c : crr) {
            if (flag && c == '*') {
                count += 1;
                continue;
            }

            if (c == '|') {
                flag = flag == true ? false : true;
            }
        }
        return count;
    }

    public List<String> cellsInRange(String s) {
        List<String> cellsInRange = new ArrayList<>();
        String[] srr = s.split(":");
        char startChar = srr[0].charAt(0);
        int startNum = Integer.parseInt(String.valueOf(srr[0].charAt(1)));

        char endChar = srr[1].charAt(0);
        int endNum = Integer.parseInt(String.valueOf(srr[1].charAt(1)));

        for (char c = startChar; c <= endChar; c++) {
            for (int i = startNum; i <= endNum; i++) {
                cellsInRange.add(c + "" + i);
            }
        }

        return cellsInRange;

    }

    public int distributeCandies(int[] candyType) {

        int count = Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size();
        int canEat = candyType.length / 2;

        if (count >= canEat) {
            return canEat;
        }

        return count;

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        if (arr.length != target.length) return false;

        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(arr, target);
    }

}


class UndergroundSystem {

    Map<Integer, DistanceMapping> map;
    Map<String, Route> route;


    public UndergroundSystem() {
        map = new HashMap<>();
        route = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map.put(id, new DistanceMapping(id, stationName, t));

    }

    public void checkOut(int id, String stationName, int t) {
        map.get(id).setCheckOut(stationName);
        map.get(id).setCheckOutTime(t);
        String key = map.get(id).getCheckIn() + "-" + stationName;
        Route m = route.get(key);
        if (m == null) {
            route.put(key, new Route(1, t - map.get(id).getCheckInTime()));
        } else {
            m.totalCount += 1;
            m.totalTime += t - map.get(id).getCheckInTime();
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        /*List<DistanceMapping> l = map.values().stream().filter(x -> x.getCheckIn().equals(startStation) &&
                        Objects.nonNull(x.getCheckOut()) && x.getCheckOut().equals(endStation))
                .collect(Collectors.toList());
        int count = l.size();
        double time = 0;
        for(DistanceMapping d : l){
            time += d.getCheckOutTime() - d.getCheckInTime();
        }
        System.out.println(count);
        System.out.println(time);*/
        return (double) route.get(startStation + "-" + endStation).totalTime / route.get(startStation + "-" + endStation).totalCount;
    }
}

class Route {
    int totalCount;
    int totalTime;

    public Route(int totalCount, int totalTime) {
        this.totalCount = totalCount;
        this.totalTime = totalTime;
    }
}

class DistanceMapping {

    private int id;
    private String checkIn;
    private String checkOut;
    private int checkInTime;
    private int checkOutTime;

    public DistanceMapping(int id, String checkIn, int checkInTime) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkInTime = checkInTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(int checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(int checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}

class CombinationIterator {

    List<String> allSubSet;
    int totalSize;
    int currPos;

    public CombinationIterator(String characters, int combinationLength) {
        allSubSet = allSubSet(characters, combinationLength);
        totalSize = allSubSet.size();
        currPos = 0;
    }

    private List<String> allSubSet(String str, int k) {
        int len = str.length();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (str.substring(i, j + 1).length() == k) {
                    l.add(str.substring(i, j + 1));
                }
            }
        }
        return l;
    }

    public String next() {
        String s = null;
        if (currPos < totalSize) {
            s = allSubSet.get(currPos);
            currPos += 1;
        }
        return s;
    }

    public boolean hasNext() {
        if (currPos < totalSize - 1) {
            return true;
        }

        return false;
    }
}

class StreamChecker {

    StringBuilder words;

    public StreamChecker(String[] words) {
        this.words = new StringBuilder();
        for (String word : words) {
            this.words.append(word.charAt(word.length() - 1));
        }
    }

    public boolean query(char letter) {
        return words.toString().contains(letter + "");
    }
}
