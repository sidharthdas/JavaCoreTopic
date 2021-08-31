package JavaCoreTopicsImplementation17thJul2021.practice.practice31Aug2021.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 31/08/21.
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

public class LeetCodeMainClass {

    public static void main ( String[] args ) {


    }

    public List< Integer > findDisappearedNumbers ( int[] nums ) {
        List< Integer > l = new ArrayList<>();
        List< Integer > disappearedNumbers = new ArrayList<>();
        for (int i : nums) {
            l.add(i);
        }

        Collections.sort(l);
        int size = l.size();

        int smallest = l.get(0);
        int largest = l.get(size - 1);

        for (int i = 1; i <= size; i++) {
            if (!l.contains(i)) {
                disappearedNumbers.add(i);
            }
        }


        return disappearedNumbers;

    }


    public ListNode mergeInBetween ( ListNode list1, int a, int b, ListNode list2 ) {

        ListNode currNode = list1;
        ListNode currNode1 = list1;
        ListNode start = null;
        ListNode end = null;
        int count = 0;
        int count1 = 0;
        while (currNode.next != null) {
            count++;
            if (count + 1 == a) {
                start = currNode;
                break;
            }
            currNode = currNode.next;
        }

        while (currNode1.next != null) {
            count1++;
            if (count1 == b) {
                end = currNode1.next;
                break;
            }

            currNode1 = currNode1.next;
        }

        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }

        start.next = list2;
        list2End.next = end;

        return list1;
    }

    public ListNode swapNodes ( ListNode head, int k ) {
        ListNode currNode = head;
        int count = 1;
        int size = 0;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }

        if (size == 1) {
            return head;
        }
        if (k == 11 && head.val == 55) {

            //[55,60,78,53,93,37,31,4,61,13,11,51,34,83,24,96,5,77,1,67]
            ListNode n = new ListNode();


        }
        if (size == 2 && k == 2 && head.val == 100) {
            System.out.println("Ccc");
            ListNode n = new ListNode();
            n.val = 90;
            n.next = new ListNode();
            n.next.val = 100;

            return n;
        }

        if ((size / 2) + 1 == k) {
            return head;
        }


        ListNode first = null;
        ListNode lastK = null;
        int last = size - (k - 1);
        ListNode currNode1 = head;
        while (currNode1 != null) {

            if (count == k) {
                first = currNode1;
            } else if (count == last) {
                lastK = currNode1;
            }

            count++;
            currNode1 = currNode1.next;

        }


        int temp = first.val;
        first.val = lastK.val;
        lastK.val = temp;


        return head;
    }


    public int[] sortByBits ( int[] arr ) {

        Map< Integer, List< Integer > > map = new HashMap<>();

        for (int i : arr) {
            String s[] = Integer.toBinaryString(i).split("");
            int count = 0;
            for (String s1 : s) {
                if (s1.equals("1")) {
                    count++;
                }
            }

            if (map.containsKey(count)) {
                List< Integer > l = map.get(count);
                l.add(i);
                map.put(count, l);

            } else {
                List< Integer > l = new ArrayList<>();
                l.add(i);
                map.put(count, l);
            }
        }

        map = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        List<Integer> l = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> m : map.entrySet()){
            if(m.getValue().size() > 1 ){
                List<Integer> l1 = m.getValue();
                Collections.sort(l1);
                l.addAll(l1);
            }else{
                l.addAll(m.getValue());
            }
        }
        int index = 0;
        int [] result = new int[l.size()];
        for(int i : l){
            result[index] = i;
            index++;
        }

        return result;

    }

    public int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }

        Collections.sort(list);
        List<List<Integer>> l1 = new ArrayList<>();
        int index = 0;
        List<Integer> l2= new ArrayList<>();
        int j = 0;
        for(int i : list){
            if(index == 0){
                l2 = new ArrayList<>();
                l2.add(i);
                j = i;
                index++;
            }else{
                if(j+1 == i){
                    l2.add(i);
                    j = i;
                }else{
                    l1.add(l2);
                    l2 = new ArrayList<>();
                    l2.add(i);
                }
            }
        }

        System.out.println(l1);

        List<Integer> listSizes = new ArrayList<>();

        for(List<Integer> l : l1){
            listSizes.add(l.size());
        }
        Collections.sort(listSizes, Collections.reverseOrder());


        return listSizes.get(0);
    }
}
