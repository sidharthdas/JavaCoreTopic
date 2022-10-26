package Oct4Th2022.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sidharth Das
 * created on  26/10/22
 */
public class LeetcodeMainClass16 {
    public static void main(String[] args) {

    }

    public boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        char[] movesArr = moves.toCharArray();

        for (char c : movesArr) {
            if(c == 'U')  x++;
            else if(c == 'D') x--;
            else if(c == 'R') y++;
            else if(c == 'L') y--;
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
