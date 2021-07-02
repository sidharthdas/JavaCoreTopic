package JUNE.programmingQuestion;

import java.math.BigInteger;

/**
 * @author sidharthdas on 02/07/21.
 */


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  class LinkedListLL{
      ListNode head = null;

      public LinkedListLL insertAtFirst(LinkedListLL list, int data){
          ListNode node = new ListNode(data);
          if(list.head == null){
              list.head = node;
          }else{
              node.next = list.head;
              list.head = node;
          }
          return list;
      }
  }

public class LeetCodeAddTwoNumberLinkedList {

    public static void main ( String[] args ) {

        LinkedListLL ll = new LinkedListLL();
        ll = ll.insertAtFirst(ll, 9);


        LinkedListLL ll1 = new LinkedListLL();
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 9);
        ll1 = ll1.insertAtFirst(ll1, 1);

        LeetCodeAddTwoNumberLinkedList leetCodeAddTwoNumberLinkedList = new LeetCodeAddTwoNumberLinkedList();

        leetCodeAddTwoNumberLinkedList.addTwoNumbers(ll.head, ll1.head);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String s1 = "";
        String s2 = "";

        ListNode currNode = l1;
        while(currNode != null){
            s1 = s1 + String.valueOf(currNode.val);
            currNode = currNode.next;
        }

        ListNode currNode1 = l2;
        while(currNode1 != null){
            s2 = s2 + String.valueOf(currNode1.val);
            currNode1 = currNode1.next;
        }
        String s4 = "";
        String s5 = "";
        for(int i = s1.length()-1; i>=0; i--){
            s4+= s1.charAt(i);
        }

        for(int i = s2.length()-1; i>=0; i--){
            s5+= s2.charAt(i);
        }
        BigInteger bi1 = new BigInteger(s4);
        BigInteger bi2 = new BigInteger(s5);



        BigInteger i = bi1.add(bi2);

        System.out.println(i);

        String[] str = String.valueOf(i).split("");

        LinkedListLL ll = new LinkedListLL();
        for(String s0: str){
            ll = ll.insertAtFirst(ll, Integer.parseInt(s0));
        }


        return ll.head;
    }
}
