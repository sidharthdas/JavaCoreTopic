package Oct4Th2022.leetcode;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  16/01/23
 */
public class Leetcode23MainClass {

    public static void main(String[] args) {

        /*double n = 3000.12;

        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format(n);

        System.out.println(val);

        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        String val2 = nf2.format(n);

        System.out.println(val2);

        NumberFormat nf3 = NumberFormat.getInstance(new Locale("da", "DK"));
        String val3 = nf3.format(n);

        System.out.println("Double: "+ String.valueOf(n));
        System.out.println("DK : "+val3);*/

        System.out.println(kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        Map<Integer, Integer> map = Map.ofEntries(
                Map.entry(1,31),
                Map.entry(2,28),
                Map.entry(3,31),
                Map.entry(4,3),
                Map.entry(5,31),
                Map.entry(6,3),
                Map.entry(7,31),
                Map.entry(8,31),
                Map.entry(9,3),
                Map.entry(10,31),
                Map.entry(11,3),
                Map.entry(12,31)
        );
        String[] arriveAliceArr = arriveAlice.split("-");
        String[] leaveAliceArr = leaveAlice.split("-");
        int monthOfArrivalAlice = Integer.parseInt(arriveAliceArr[0]);
        int dayOfArrivalAlice = Integer.parseInt(arriveAliceArr[1]);

        int monthOfLeaveAlice = Integer.parseInt(leaveAliceArr[0]);
        int dayOfLeaveAlice = Integer.parseInt(leaveAliceArr[1]);

        return 2;

    }

    public int maximumPopulation(int[][] logs) {
        return 0;

    }

    public int maximumCount(int[] nums) {

        int  greater =(int) Arrays.stream(nums).boxed().filter(x -> x >0).count();
        int  smaller = (int )Arrays.stream(nums).boxed().filter(x -> x < 0).count();

        return greater > smaller ? greater : smaller;

    }


    public int closetTarget(String[] words, String target, int startIndex) {

        if(!Arrays.stream(words).toList().contains(target)){
            return -1;
        }

        int left = 0;
        int right = 0;
        int len = words.length;

        int startIndexForRight = startIndex;
        int startIndexForLeft  = startIndex;
        while(true){
            if(words[startIndexForRight].equals(target)){
                break;
            }else{
                left++;
                startIndexForRight++;
                if(startIndexForRight > len -1){
                    startIndexForRight = 0;
                }
            }
        }

        while(true){
            if(words[startIndexForLeft].equals(target)){
                break;
            }else{
                right++;
                startIndexForLeft--;
                if(startIndexForLeft < 0){
                    startIndexForLeft = len -1;
                }
            }
        }

        return left > right ? right : left;

    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        Map<List<Integer>, Double> map = new HashMap<>();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                map.put(List.of(arr[i], arr[j]), (double)arr[i]/(double)arr[j]);
            }
        }

        List<List<Integer>> l = map.entrySet().stream().sorted(Map.Entry.<List<Integer>, Double>comparingByValue())
                .map(Map.Entry::getKey).toList();
        return new int[]{l.get(k-1).get(0), l.get(k-1).get(1)};

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int indexOfX = Arrays.stream(arr).boxed().toList().indexOf(x);
        int backIndex = indexOfX - 1;
        int forwardIndex = indexOfX + 1;
        List<Integer> in = new ArrayList<>();
        in.add(x);
        while(in.size() < k){
            if(backIndex >= 0){
                in.add(arr[backIndex]);
                backIndex-=1;
            }
            while(in.size() < k) {
                if (forwardIndex < len) {
                    in.add(arr[forwardIndex]);
                    forwardIndex += 1;
                }
            }
        }
        return in.stream().sorted().toList();
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<String>> creatorsWithIds = new HashMap<>();
        Map<String, Long> creatorsWithViews = new HashMap<>();
        Map<String, Map<String, Integer>> creatorsWithSeparate = new HashMap<>();
        int count = creators.length;

        for(int i = 0; i < count; i++){
            creatorsWithIds.putIfAbsent(creators[i],new ArrayList<>());
            creatorsWithIds.get(creators[i]).add(ids[i]);
            creatorsWithViews.put(creators[i], creatorsWithViews.getOrDefault(creators[i], 0l)+ views[i]);
            creatorsWithSeparate.putIfAbsent(creators[i], new HashMap<>());
            creatorsWithSeparate.get(creators[i]).put(ids[i], views[i]);
        }

        long highestView = creatorsWithViews.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .findFirst().get().getValue();

        List<String> keys = creatorsWithViews.entrySet().stream().filter(x -> x.getValue() == highestView).map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<List<String>> finalList = new ArrayList<>();

        keys.forEach(x -> {
            List<String> l = new ArrayList<>();
            l.add(x);
            int val = creatorsWithSeparate.get(x).entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .findFirst().get().getValue();
            l.add(creatorsWithSeparate.get(x).entrySet().stream().filter(y -> y.getValue() == val)
                    .map(Map.Entry::getKey)
                    .sorted().findFirst().get());
            //l.add(creatorsWithIds.get(x).stream().sorted(Comparator.reverseOrder()).findFirst().get());
            finalList.add(l);
        });
        return finalList;
    }
}

class NumberContainers {
    Map<Integer, Integer> map;

    public NumberContainers() {
        map = new TreeMap<>();
    }

    public void change(int index, int number) {
        map.put(index, number);
    }

    public int find(int number) {
        if(map.entrySet().stream().filter(x -> x.getValue() == number).count() == 0){
            return -1;
        }
        Map.Entry<Integer, Integer> e = map.entrySet().stream().filter(x -> x.getValue() == number)
                .findFirst().get();
        return e.getKey();
    }
}