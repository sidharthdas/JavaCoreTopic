package Oct4Th2022.leetcode;

import java.util.*;

/**
 * @author Sidharth Das
 * created on  14/10/22
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LeetcodeMain13 {

    public static void main(String[] args) {
        //findMin(new int[]{1,2,3,45});
        Random rand = new Random();
        rand.nextInt(2);
    }

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> l = new ArrayList<>();

        map.entrySet().forEach(x -> {
            if(x.getValue() > len/3){
                l.add(x.getKey());
            }
        });
        return l;
    }

    public boolean search1(int[] nums, int target) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        return l.contains(target);

    }

    public int search(int[] nums, int target) {
        List<Integer> l = Arrays.stream(nums).boxed().toList();
        if(!l.contains(target)) return -1;
        return l.indexOf(target);

    }

    public static int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];

    }

    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode n = head;
        ListNode node = head;

        while (node != null) {
            count++;
            node = node.next;
        }

        int middleIndex = count / 2;
        while (middleIndex-- > 1) {
            head = head.next;
        }
        head.next = head.next.next;
        return n;
    }

}
