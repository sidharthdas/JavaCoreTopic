package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  11/10/22
 */
public class LeetcodeMain10 {
    public static void main(String[] args) {
        /*
        * ["SORTracker", "add", "add", "get", "add", "get", "add", "get", "add", "get", "add", "get", "get"]
[[], ["bradford", 2], ["branford", 3], [], ["alps", 2], [], ["orland", 2], [], ["orlando", 3], [], ["alpine", 2], [], []]
        * */

        SORTracker tracker = new SORTracker();
        tracker.add("bradford", 2);
        tracker.add("branford", 3);
        System.out.println(tracker.get());
        tracker.add("alps", 2);
        System.out.println(tracker.get());
        tracker.add("orland", 2);
        System.out.println(tracker.get());
        tracker.add("orlando", 3);
        System.out.println(tracker.get());
        tracker.add("alpine", 2);
        System.out.println(tracker.get());
        System.out.println(tracker.get());

    }
}

class Location{
    String locName;
    int score;

    public Location(String locName, int score) {
        this.locName = locName;
        this.score = score;
    }
}

class SORTracker {
    List<Location> list;
    int count = 0;

    public SORTracker() {
        list = new ArrayList<>();
    }

    public void add(String name, int score) {
        Location l= new Location(name, score);
        list.add(l);

    }

    public String get() {
        Comparator<Location> c = (x, y) ->{
            if(x.score > y.score){
                return -1;
            }else if(x.score < y.score){
                return 1;
            }else{
                return 0;
            }
        };
        Comparator<Location> c1 = (x, y) ->{
          return x.locName.compareTo(y.locName);
        };

        int temp = count;
        count +=1;

        return   list.stream().sorted(c.thenComparing(c1)).toList().get(temp).locName;
    }
}
