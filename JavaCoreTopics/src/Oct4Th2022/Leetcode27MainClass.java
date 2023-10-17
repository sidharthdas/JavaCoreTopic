package Oct4Th2022;


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

public class Leetcode27MainClass {

    public static void main(String[] args) {

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = new ListNode();
        temp.val = head.val;
        int first = temp.val;
        int sec = 1;
        ListNode temp2 = temp;
        while (head.next != null) {
            sec = head.next.val;
            int gcd = gcd(first, sec);
            ListNode node1 = new ListNode();
            ListNode node2 = new ListNode();
            node2.val = sec;
            node1.val = gcd;
            node1.next = node2;
            temp.next = node1;
            temp = node2;
            first = sec;
            head = head.next;

        }
        return temp2;
    }

    private int gcd(int x, int y) {
        int gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }

        return gcd;
    }
}
