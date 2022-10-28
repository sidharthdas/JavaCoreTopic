package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  28/10/22
 */
public class LeetcodeMainClass18 {
    public static void main(String[] args) {

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
            if(truckSize < t.numOfBoxes){
                count += truckSize * t.numOfUnitPerBox;
                break;
            }else if(truckSize == t.numOfBoxes){
                count += truckSize * t.numOfUnitPerBox;
                break;
            }else{
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