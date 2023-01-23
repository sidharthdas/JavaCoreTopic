package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  23/01/23
 */
public class Leetcode24MainClass {

    public static void main(String[] args) {

    }
}

class DataStream {
    int value;
    int k;
    List<Integer> l;

    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
        l = new ArrayList<>();
    }

    public boolean consec(int num) {
        l.add(num);
        if(l.size() < k){
            return false;
        }
        int lastIn = l.size() - 1;
        int count = 0;
        while(lastIn >= 0){
            if(l.get(lastIn) == value){
                count ++;
                if(count == k){
                    return true;
                }
            }else{
                if(count != k){
                    break;
                }
            }
            lastIn --;
        }

        return false;
    }
}