package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  28/10/22
 */
public class LeetcodeMainClass18 {
    public static void main(String[] args) {

        System.out.println(isValid("[])"));

    }

    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.toString().contains("(")){
            int indexOfFirst =  s.indexOf("(");
            int indexOfSec =  s.indexOf(")");

            //String s1 = s.substring(s.indexOf("("), s.indexOf(")") + 1);
            String code = s.substring(indexOfFirst + 1, indexOfSec);

            String replace = "?";

            for(List<String> l : knowledge){
                if(l.get(0).equals(code)){
                    replace = l.get(1);
                    break;
                }
            }
            sb = sb.replace(indexOfFirst, indexOfSec, replace);
        }
        return sb.toString();
    }

    public static boolean isValid(String s) {

        String srr[] = s.split("");
        if(srr[0].equals("]") || srr[0].equals("}") || srr[0].equals(")")) return false;
        Stack<String> stack = new Stack<>();

        for (String s1 : srr) {
            if (s1.equals("(") || s1.equals("[") || s1.equals("{")) {
                stack.push(s1);
            } else {
                if(stack.size() > 0) {
                    if (!getOp(s1).equals(stack.pop())) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static String getOp(String s) {
        if (s.equals("]")) return "[";
        else if (s.equals("}")) return "{";
        else if (s.equals(")")) return "(";
        return null;
    }

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
    * */

    public int romanToInt(String s) {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("I", 1),
                Map.entry("V", 5),
                Map.entry("X", 10),
                Map.entry("L", 50),
                Map.entry("C", 100),
                Map.entry("D", 500),
                Map.entry("M", 1000)
        );

        int count = 0;
        String[] srr = s.split("");
        int len = srr.length;

        for (int i = 0; i < len; i++) {
            count += map.get(srr[i]);
        }
        return count;
    }

    public double averageWaitingTime(int[][] customers) {
        double currentTime = 0;
        double waitingTime = 0;
        int len = customers.length;
        for (int[] cus : customers) {
            currentTime = (currentTime > (cus[0] * 1.0) ? currentTime : (cus[0] * 1.0)) + cus[1];
            waitingTime += currentTime - cus[0];
        }

        return waitingTime / len;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Truck> list = new ArrayList<>();
        for (int[] box : boxTypes) {
            list.add(new Truck(box[1], box[0]));
        }

        Comparator<Truck> comp = (x1, x2) -> {
            if (x1.numOfUnitPerBox > x2.numOfUnitPerBox) return -1;
            else if (x1.numOfUnitPerBox < x2.numOfUnitPerBox) return 1;
            else return 0;
        };

        Collections.sort(list, comp);

        int count = 0;

        for (Truck t : list) {
            if (truckSize < t.numOfBoxes) {
                count += truckSize * t.numOfUnitPerBox;
                break;
            } else if (truckSize == t.numOfBoxes) {
                count += truckSize * t.numOfUnitPerBox;
                break;
            } else {
                count += t.numOfBoxes * t.numOfUnitPerBox;
                truckSize -= t.numOfBoxes;
            }
        }
        return count;
    }
}

class Truck {

    int numOfUnitPerBox;
    int numOfBoxes;

    public Truck(int numOfUnitPerBox, int numOfBoxes) {
        this.numOfUnitPerBox = numOfUnitPerBox;
        this.numOfBoxes = numOfBoxes;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "numOfUnitPerBox=" + numOfUnitPerBox +
                ", numOfBoxes=" + numOfBoxes +
                '}';
    }
}