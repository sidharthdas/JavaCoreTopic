package JUNE.linkedlistwithallfunctionalities;

/**
 * @author sidharthdas on 28/06/21.
 */

/* LINKEDLIST WITH ALL FUNCTIONALITIES
 *
 *   1. Insert at beginning.
 *   2. Insert at end.
 *   3. Insert after any node.
 *   4. Delete a node.
 *   5. Print list.
 * */

class Node {
    int data;
    Node next;

    public Node ( int data ) {
        this.data = data;
    }
}

class LinkedList {

    Node head = null;

    // 1. Insert at beginning
    public LinkedList insertAtBeginning ( LinkedList list, int data ) {
        Node node = new Node(data);
        if (list.head == null) {
            list.head = node;
        } else {
            node.next = list.head;
            list.head = node;
        }

        return list;
    }

    // 2. Insert at end.
    public LinkedList insertAtEnd ( LinkedList list, int data ) {
        Node node = new Node(data);
        if (list.head == null) {
            list.head = node;
        } else {
            Node lastNode = list.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
        return list;
    }

    // 3. Insert after any node.
    public void insertAfterAnyNode ( Node node, int data ) {
        if (node == null) {
            return;
        }

        Node newNode = new Node(data);
        if (node.next == null) {
            node.next = newNode;
        } else {

            Node nextNode = node.next;
            newNode.next = nextNode;
            node.next = newNode;
        }
    }

    public void deleteNode(Node node){
        if(node == null){
            return;
        }
        if(node.next != null){
            Node nextNode = node.next;
            node.data = nextNode.data;
            node.next = nextNode.next;
            nextNode = null;
        }else if(node.next == null){

        }
    }

    public void printList(LinkedList list){
        if(list.head == null){
            return;
        }
        Node currNode = list.head;
        while(currNode!= null){
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
    }
}

public class LinkedListWithAllFunctionalitiesMainClass {


    public static void main ( String[] args ) {

        LinkedList list = new LinkedList();

        list = list.insertAtBeginning(list, 10);
        list = list.insertAtBeginning(list, 20);
        list = list.insertAtBeginning(list, 30);
        list = list.insertAtBeginning(list, 40);
        list = list.insertAtBeginning(list, 50);
        list = list.insertAtBeginning(list, 60);
        list = list.insertAtBeginning(list, 70);
        list = list.insertAtBeginning(list, 80);
        list = list.insertAtBeginning(list, 90);

        list.printList(list);

        System.out.println();
        Node node = list.head;
        while(node != null){
            if(node.data == 10){
                list.deleteNode(node);
                break;
            }
            node = node.next;
        }

        list.printList(list);
    }
}
