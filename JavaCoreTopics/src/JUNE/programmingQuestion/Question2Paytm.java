package JUNE.programmingQuestion;

/**
 * @author sidharthdas on 27/06/21.
 */

class Node {
    int data;
    Node next;
}

class LinkedList {

    Node head = null;

    public LinkedList insert ( int data, LinkedList list ) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
        return list;
    }


    public void printList ( LinkedList list ) {
        if (list.head == null) {
            return;
        }
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.data + ", ");
            currNode = currNode.next;

        }
    }

    public void deleteNode ( Node node ) {

        Node nextNode = node.next;
        if (nextNode == null) {
            node = null;
            return;
        }
        int val = nextNode.data;

        node.data = val;
        node.next = nextNode.next;
        //nextNode = null;
    }
}

public class Question2Paytm {


    public static void main ( String[] args ) {

        LinkedList list = new LinkedList();

        list = list.insert(10, list);
        list = list.insert(20, list);
        list = list.insert(30, list);
        list = list.insert(40, list);
        list = list.insert(50, list);
        list = list.insert(60, list);
        list = list.insert(70, list);

        list.printList(list);

        System.out.println();
        Node node = list.head;
        while (node != null) {
            if (node.data == 70) {
                list.deleteNode(node);
                break;
            }
            node = node.next;

        }

        list.printList(list);


    }


}
