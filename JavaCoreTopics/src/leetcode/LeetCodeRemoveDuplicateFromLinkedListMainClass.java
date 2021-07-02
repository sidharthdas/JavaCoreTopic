package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sidharthdas on 02/07/21.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode () {
    }

    ListNode ( int val ) {
        this.val = val;
    }

    ListNode ( int val, ListNode next ) {
        this.val = val;
        this.next = next;
    }
}

class LinkedListLL {
    ListNode head = null;

    public LinkedListLL insertAtLat ( LinkedListLL list, int data ) {
        ListNode node = new ListNode(data);
        if (list.head == null) {
            list.head = node;
        } else {
            ListNode n = list.head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }
        return list;
    }
}

public class LeetCodeRemoveDuplicateFromLinkedListMainClass {
    public static void main ( String[] args ) {




        LinkedListLL ll1 = new LinkedListLL();
        ll1 = ll1.insertAtLat(ll1, 1);
        ll1 = ll1.insertAtLat(ll1, 1);
        ll1 = ll1.insertAtLat(ll1, 2);
        ll1 = ll1.insertAtLat(ll1, 3);
        ll1 = ll1.insertAtLat(ll1, 3);

        LeetCodeRemoveDuplicateFromLinkedListMainClass leetCodeRemoveDuplicateFromLinkedListMainClass = new LeetCodeRemoveDuplicateFromLinkedListMainClass();

        ListNode node= leetCodeRemoveDuplicateFromLinkedListMainClass.deleteDuplicates(ll1.head);

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicates ( ListNode head ) {

        if(Objects.isNull(head) ){
            return null;
        }

        ListNode currNode = head;
        List< Integer > list = new ArrayList<>();
        list.add(currNode.val);

        while (currNode.next != null) {
            if (list.contains(currNode.next.val)) {
                ListNode n = currNode.next.next;
                currNode.next = n;
                currNode = currNode.next;
            } else {
                list.add(currNode.val);
                currNode = currNode.next;
            }

        }

        ListNode last = head;
        ListNode secLast = null;



        while(last.next != null){
            secLast = last;
            last = last.next;
        }

        if(secLast.val == last.val){
            secLast.next = null;
        }

        return head;

    }
}
