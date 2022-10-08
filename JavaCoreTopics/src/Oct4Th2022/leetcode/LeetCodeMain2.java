package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  07/10/22
 */
public class LeetCodeMain2 {

    public static void main(String[] args) {

        System.out.println(reorderedPowerOf2(46));


    }

    public String arrangeWords1(String text) {
        List<String> lWords = new ArrayList<>();
        List<Integer> lIndexes = new ArrayList<>();
        Map<Integer, List<String>> mapCount = new HashMap<>();
        
        String[] arr = text.split("");
        int len = arr.length;
        for(int i = 0; i < len; i++){
            lWords.add(arr[i]);
            lIndexes.add(i);
            int size = arr[i].length();
            
            if(mapCount.containsKey(size)){
                List<String> l = mapCount.get(size);
                l.add(arr[i]);
                mapCount.put(size, l);
            }else{
                List<String> l = new ArrayList<>();
                l.add(arr[i]);
                mapCount.put(size, l);
            }
        }
        
        mapCount = mapCount.entrySet().stream().sorted(Map.Entry.<Integer, List<String>>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
        
        String s = "";
        
        for(Map.Entry<Integer, List<String>> map : mapCount.entrySet()){
            if(map.getValue().size() == 1){
                s += map.getValue().get(0) + " ";
            }else{
                //List<String> l1 = getOrderedList(map.getValue(), lWords, lIndexes);
            }
        }
        
        return null;
        

    }


    public String arrangeWords(String text) {
        String s[] = text.split(" ");
        Arrays.sort(s , (x , y) -> x.length() - y.length());
        String finalString = String.join(" ", s);
        finalString = finalString.toLowerCase();
        String first = finalString.substring(0,1).toUpperCase();
        return  first + finalString.substring(1);

    }

    public static  boolean reorderedPowerOf2(int n) {
        int i = 2;
        boolean flag = false;
        while(!(i > n)){
            if(i == n){
                flag = true;
                break;
            }
            i = i*2;
        }

        return flag;
    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Team> map = new HashMap<>();

        for(int[] match : matches){
            //matches[i] = [winneri, loseri]
            if(map.containsKey(match[0])){
                Team t = map.get(match[0]);
                int win = t.getWin();
                t.setWin(win + 1);
                map.put(match[0], t);
            }else{
                Team t = new Team();
                t.setWin(1);
                map.put(match[0], t);
            }

            if(map.containsKey(match[1])){
                Team t = map.get(match[1]);
                int loss = t.getLoss();
                t.setLoss(loss + 1);
                map.put(match[1], t);
            }else{
                Team t = new Team();
                t.setLoss(1);
                map.put(match[1], t);
            }
        }

        List<List<Integer>> finalList = new ArrayList<>();
        Set<Integer> l1 = new TreeSet<>();
        Set<Integer> l2 = new TreeSet<>();

        for(Map.Entry<Integer, Team> m : map.entrySet()){
            if(m.getValue().getLoss() == 0){
                l1.add(m.getKey());
            }else if(m.getValue().getLoss() == 1){
                l2.add(m.getKey());
            }
        }

        finalList.add(l1.stream().toList());
        finalList.add(l2.stream().toList());
        return finalList;
    }


}

class Team{
    private int win;
    private int loss;

    public Team() {

        this.win = 0;
        this.loss = 0;
    }



    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }


}


