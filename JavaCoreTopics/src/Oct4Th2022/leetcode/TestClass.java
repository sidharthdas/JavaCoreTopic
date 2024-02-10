package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    //5 -> 3 -> 4 ->1 -> 9
    public static void main(String[] args) {
        LinkedList5 linkedList5 = new LinkedList5();
        linkedList5.insert(5);
        linkedList5.insert(3);
        linkedList5.insert(4);
        linkedList5.insert(1);
        linkedList5.insert(9);

        linkedList5.print();

        System.out.println();

        linkedList5.reverse2();

        linkedList5.print();
    }


}


class Node5 {

    int data;
    Node5 next;

    public Node5(int data) {
        this.data = data;
    }

    public Node5() {

    }
}



class LinkedList5 {


    public Node5 root = null;

    void insert(int data) {
        if(root == null) {
            root = createNode(data);
        } else {
            Node5 temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node5(data);
        }
    }

    public void print() {
        Node5 temp = root;
        while(temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }


    Node5 createNode(int data) {
        Node5 node = new Node5();
        node.data = data;
        node.next = null;
        return node;
    }

    void reverse () {
        if(root == null){
            return;
        }

        List<Integer> l = new ArrayList<>();
        Node5 temp = root;
        while(temp != null) {
            l.add(temp.data);
            temp = temp.next;
        }

        int len = l.size();
        this.root = null;
        for(int i = len -1; i>= 0; i--) {
            insert(l.get(i));
        }


    }

    void reverse2 () {
        if(root == null){
            return;
        }

        Node5 last = root;
        Node5 secondLast = root;

        while(true) {
            while (last.next != null && last.next.next != null) {
                last = last.next.next;
                secondLast = secondLast.next;
            }

            last.next = secondLast;
            secondLast.next = null;
            last = secondLast;

        }
    }

}
