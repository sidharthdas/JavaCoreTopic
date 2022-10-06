package Oct4Th2022.leetcode;

import JavaCoreTopicsImplementation17thJul2021.abstractclass.I;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        System.out.println(1% 2);

    }

    public static  int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        List<Integer> list = new ArrayList<>();
        int el = nums[0];
        for(int i = 1; i < len; i++){
            if(el < nums[i]){
                el = nums[i];
                sum += el;
            }else{
                list.add(sum);
                sum = nums[i];
                el = nums[i];
            }
        }

        list.add(sum);

        Collections.sort(list, Collections.reverseOrder());
        return list.get(0);

    }

    public String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(names[i], heights[i]);
        }

        String[] finalList = new String[len];

        Map<String, Integer> m = map.entrySet().stream().sorted(Map.Entry.<String, Integer > comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        Integer i = 0;
        for(Map.Entry<String, Integer> m1 : m.entrySet()){
            finalList[i] = m1.getKey();
            i++;
        }
        return finalList;
    }

    public String[] sortPeople1(String[] names, int[] heights) {
        int len = names.length;
        List<String> list = new ArrayList<>();
        //Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            list.add(names[i]+"-"+heights[i]);
        }

        Comparator<String> comparator = (String s1, String s2) ->{
          int i1 = Integer.parseInt(s1.split("-")[1]);
          int i2 = Integer.parseInt(s2.split("-")[1]);

          if(i1 > i2){
              return -1;
          }else if(i1 < i2){
              return 1;
          }else{
              return 0;
          }

        };
        String[] finalList = new String[len];
        Collections.sort(list, comparator);
        int i = 0;
        for(String s : list){
            finalList[i] = s.split("-")[0];
            i++;
        }

        return finalList;


    }

    public static  int findClosestNumber(int[] nums) {
        List<Integer> listOfPos = new ArrayList<>();
        List<Integer> listOfNeg = new ArrayList<>();

        for(int i :  nums){
            if(i > 0){
                listOfPos.add(i);
            }else {
                listOfNeg.add(i);
            }
        }

        Collections.sort(listOfPos);
        Collections.sort(listOfNeg, Collections.reverseOrder());

        if(listOfPos.size() != 0 && listOfNeg.size() != 0){
            if(listOfPos.get(0) > (listOfNeg.get(0)* (-1)) ){
                return listOfNeg.get(0);
            }else{
                return  listOfPos.get(0);
            }
        }else if(listOfPos.size() == 0){
            return listOfNeg.get(0);
        }else{
            return listOfPos.get(0);
        }


    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        TreeNode root = null;
        for(int i : list){
            root = insert(root, i);
        }

        return root;


    }

    public TreeNode create(int data){
        TreeNode t = new TreeNode(data);
        return t;
    }

    public TreeNode insert(TreeNode t, int data){
        if(t == null){
            return  create(data);
        }
        if(data < t.val){
            t.left = insert(t.left, data);
        }else if(data >  t.val){
            t.right = insert(t.right, data);
        }

        return t;
    }
}


  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public int numOfStrings(String[] patterns, String word) {
          int count = 0;

          for(String s  : patterns){
              if(word.contains(s)){
                  count ++;
              }
          }

          return count;

      }

      public String freqAlphabets(String s) {
          Map<String, String> map = Map.ofEntries(
                  Map.entry("1","a"),
                  Map.entry("2","b"),
                  Map.entry("3","c"),
                  Map.entry("4","d"),
                  Map.entry("5","e"),
                  Map.entry("6","f"),
                  Map.entry("7","g"),
                  Map.entry("8","h"),
                  Map.entry("9","i"),
                  Map.entry("10#","j"),
                  Map.entry("11#","k"),
                  Map.entry("12#","l"),
                  Map.entry("13#","m"),
                  Map.entry("14#","n"),
                  Map.entry("15#","o"),
                  Map.entry("16#","p"),
                  Map.entry("17#","q"),
                  Map.entry("18#","r"),
                  Map.entry("19#","s"),
                  Map.entry("20#","t"),
                  Map.entry("21#","u"),
                  Map.entry("22#","v"),
                  Map.entry("23#","w"),
                  Map.entry("24#","x"),
                  Map.entry("25#","y"),
                  Map.entry("26#","z")
          ) ;

          int len = s.length();

          String finalString = "";

          for(int i = len -1 ; i>=0; i--){
              if(!(s.charAt(i)+"").equals("#")){
                  finalString = map.get(s.charAt(i)+"") + finalString;
              }else{
                  String code =  s.charAt(i-2)+"" +s.charAt(i-1) +s.charAt(i);
                  finalString = map.get(code) + finalString;
                  i = i-2;
              }

          }
        return finalString;
      }

      public String greatestLetter(String s) {
          Set<String> set = new TreeSet<>();
          String sArr[] = s.split("");
          for(String s1 : sArr){
              if(s.contains(s1.toLowerCase()) && s.contains(s1.toUpperCase())){
                  set.add(s1.toUpperCase());
              }
          }

          if (set.size() == 0){
              return "";
          }

          int len = set.size();

          return set.stream().collect(Collectors.toList()).get(len - 1);



      }

      public int smallestEqual(int[] nums) {

          int len = nums.length;
          int finalOut = -1;

          for(int i = 0; i < len ; i++){
                if(i % 10 == nums[i]){
                    finalOut = i;
                    break;
                }
          }

          return finalOut;

      }

      public int minMaxGame(int[] nums) {
          List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
          List<Integer> finalList = getOne(list);
          return finalList.get(0);


      }

      private List<Integer> getOne(List<Integer> l){
          if(l.size() == 1){
              return l;
          }
          boolean flag = true;
          int len = l.size();
          List<Integer> finalList = new ArrayList<>();
          for(int i = 0; i < len; i++){
              if(flag){
                  int a = l.get(i) < l.get(i+1) ? l.get(i) : l.get(i+1);
                  finalList.add(a);
                  i+=1;
                  flag = false;
              }else{
                  int a = l.get(i) > l.get(i+1) ? l.get(i) : l.get(i+1);
                  finalList.add(a);
                  i+=1;
                  flag = true;
              }

          }
          return getOne(finalList);
      }

      public int mostFrequentEven(int[] nums) {
          Map<Integer, Integer> map = new HashMap<>();
          for(int i : nums){
              if(i % 2 == 0  ){
                  if(map.containsKey(i)){
                      map.put(i, map.get(i)+1);
                  }else{
                      map.put(i,1);
                  }

              }
          }

          if(map.size() == 0){
              return -1;
          }

          if(map.size() == 1){
              return map.keySet().stream().findFirst().get();
          }else{
             int highest = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);

             return map.entrySet().stream().filter(x ->x.getValue() == highest).sorted(Map.Entry.<Integer, Integer>comparingByKey())
                     .findFirst().get().getKey();
          }

      }


  }




