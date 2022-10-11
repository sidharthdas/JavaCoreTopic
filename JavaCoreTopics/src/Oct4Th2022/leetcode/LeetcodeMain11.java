package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  11/10/22
 */
public class LeetcodeMain11 {
    public static void main(String[] args) {

        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);   // [1]
        q.pushBack(2);    // [1, 2]
        q.pushMiddle(3);  // [1, 3, 2]
        q.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q.popFront());     // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle());    // return 3 -> [4, 2]
        System.out.println(q.popMiddle());    // return 4 -> [2]
        System.out.println(q.popBack());      // return 2 -> []
        System.out.println(q.popFront());     // return -1 -> [] (The queue is empty)

    }
}

class FrontMiddleBackQueue {

    List<Integer> list;

    public FrontMiddleBackQueue() {
        list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(val);
    }

    public void pushMiddle(int val) {
        int middle = list.size() / 2;
        list.add(middle + 1, val);
    }

    public void pushBack(int val) {
        if(list.size() ==0){
            list.add(val);
        }else{
            list.add(0, val);
        }
    }

    public int popFront() {
        int size = list.size();
        if(size == 0){
            return -1;
        }
        int val = list.get(size-1);
        return list.remove(size-1);

    }

    public int popMiddle() {
        int middle = list.size()/2;
        return list.remove(middle + 1);

    }

    public int popBack() {
        return list.remove(0);
    }
}

