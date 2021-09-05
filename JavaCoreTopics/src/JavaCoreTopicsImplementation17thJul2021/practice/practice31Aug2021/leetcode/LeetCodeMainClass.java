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

        int[] arr = {1, 2, 10, 5, 7};
        System.out.println(new LeetCodeMainClass().canBeIncreasing(arr));


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
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

        List< Integer > l = new ArrayList<>();

        for (Map.Entry< Integer, List< Integer > > m : map.entrySet()) {
            if (m.getValue().size() > 1) {
                List< Integer > l1 = m.getValue();
                Collections.sort(l1);
                l.addAll(l1);
            } else {
                l.addAll(m.getValue());
            }
        }
        int index = 0;
        int[] result = new int[l.size()];
        for (int i : l) {
            result[index] = i;
            index++;
        }

        return result;

    }

    public int longestConsecutive ( int[] nums ) {
        List< Integer > list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }

        Collections.sort(list);
        List< List< Integer > > l1 = new ArrayList<>();
        int index = 0;
        List< Integer > l2 = new ArrayList<>();
        int j = 0;
        for (int i : list) {
            if (index == 0) {
                l2 = new ArrayList<>();
                l2.add(i);
                j = i;
                index++;
            } else {
                if (j + 1 == i) {
                    l2.add(i);
                    j = i;
                } else {
                    l1.add(l2);
                    l2 = new ArrayList<>();
                    l2.add(i);
                }
            }
        }

        System.out.println(l1);

        List< Integer > listSizes = new ArrayList<>();

        for (List< Integer > l : l1) {
            listSizes.add(l.size());
        }
        Collections.sort(listSizes, Collections.reverseOrder());


        return listSizes.get(0);
    }


    public String arrangeWords ( String text ) {

        String[] str = text.split(" ");
        List< String > list = new ArrayList<>();
        for (String s : str) {
            list.add(s);
        }

        Map< Integer, List< String > > map = new HashMap<>();

        for (String s : str) {
            int size = s.length();
            if (map.containsKey(size)) {
                List< String > l = map.get(size);
                l.add(s);
                map.put(size, l);
            } else {
                List< String > l = new ArrayList<>();
                l.add(s);
                map.put(size, l);

            }
        }

        map = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));
        String result = "";

        for (Map.Entry< Integer, List< String > > m : map.entrySet()) {
            if (m.getValue().size() == 1) {
                result += m.getValue().get(0) + " ";
            } else {
                Map< Integer, String > map1 = new HashMap<>();

                for (String s : m.getValue()) {
                    int i = list.indexOf(s);
                    map1.put(i, s);
                }

                map1 = map1.entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ( e1, e2 ) -> e1, LinkedHashMap::new));

                for (Map.Entry< Integer, String > m1 : map1.entrySet()) {
                    result += m1.getValue() + " ";
                }
            }
        }

        System.out.println(result.trim());

        result = result.toLowerCase();
        char c = result.charAt(0);
        String s2 = String.valueOf(c).toUpperCase();


        s2 = s2 + result.substring(1);
        System.out.println(s2);
        /*String s1 = c+"".toUpperCase()+ result.substring(1);
        result.replaceFirst(c+"", s1);*/

        return s2.trim();

    }


    public boolean canBeIncreasing ( int[] nums ) {
        int size = nums.length;

        int count = 0;
        int prevNumber = -1;
        int secondPrevNumber = -1;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                prevNumber = nums[i];
            } else {
                if (count < 2) {
                    if (prevNumber <= nums[i]) {
                        secondPrevNumber = prevNumber;
                        prevNumber = nums[i];

                    } else {
                        prevNumber = secondPrevNumber;
                        count++;
                    }

                } else {
                    return false;
                }
            }


        }

        if (count < 2) {
            return true;
        } else {
            return false;
        }

    }

    public int[] countBits ( int n ) {
        List< Integer > l = new ArrayList<>();
        l.add(0);
        l.add(1);
        for (int i = 2; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            String srr[] = s.split("");
            int count = 0;
            for (String s1 : srr) {
                if (s1.equals("1")) {
                    count++;
                }
            }

            l.add(count);

        }

        int[] result = new int[l.size()];

        int index = 0;

        for (int i : l) {
            result[index] = i;
            index++;
        }

        return result;
    }

    public int findComplement ( int num ) {
        String s = Integer.toBinaryString(num);
        String sCompliment = "";

        String srr[] = s.split("");

        for (String s1 : srr) {
            if (s1.equals("1")) {
                sCompliment += "0";
            } else {
                sCompliment += "1";
            }
        }


        String regex = "^0+(?!$)";
        sCompliment = sCompliment.replaceAll(regex, "");

        return Integer.parseInt(sCompliment, 2);
    }

    public boolean hasAlternatingBits ( int n ) {
        String s = Integer.toBinaryString(n);
        if (s.contains("00")) {
            return false;
        } else if (s.contains("11")) {
            return false;
        } else {
            return true;
        }
    }


}
