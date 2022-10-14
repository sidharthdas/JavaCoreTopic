package Oct4Th2022.leetcode;

import java.util.Arrays;

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
        findMin(new int[]{1,2,3,45});
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
