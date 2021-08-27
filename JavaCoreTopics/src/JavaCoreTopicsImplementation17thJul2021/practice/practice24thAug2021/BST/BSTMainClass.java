package JavaCoreTopicsImplementation17thJul2021.practice.practice24thAug2021.BST;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 24/08/21.
 */
class Node {
    int data;
    Node left;
    Node right;
}

class BST {

    public Node insert ( Node node, int data ) {
        if (node == null) {
            return createNewNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    private Node createNewNode ( int data ) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;

        return node;
    }

    public Node remove ( Node node, int data ) {
        if (node == null) {
            return null;

        }

        if (data < node.data) {
            node.left = remove(node.left, data);
        } else if (data > node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.data = getSuccessor(node);
                node.right = remove(node.right, node.data);
            }
        }
        return node;
    }

    private int getSuccessor ( Node node ) {
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }
}


public class BSTMainClass {   //

    public static void main ( String[] args ) {

        Set< Integer > set = new HashSet<>();

        for (int i : set) {

        }
    }


    public int[] frequencySort ( int[] nums ) {
        Map< Integer, Integer > map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

       map = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));

        Map<Integer, List<Integer>> newMap = new HashMap<>();

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(newMap.containsKey(m.getValue())){
                List<Integer> l = newMap.get(m.getValue());
                l.add(m.getKey());
                newMap.put(m.getValue(), l);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(m.getKey());
                newMap.put(m.getValue(), l);

            }
        }
        System.out.println(newMap);

        List<Integer> l = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> m : newMap.entrySet()){
            Collections.sort(m.getValue(), Collections.reverseOrder());
            for(int i : m.getValue()){
                for(int j = 0; j < m.getKey(); j++){
                    l.add(i);
                }
            }
        }

        System.out.println(l);

        int[] result = new int[l.size()];

        int index = 0;
        for(int i : l){
            result[index] = i;
            index++;
        }
        return result;
    }


    public String customSortString(String order, String s) {
        final String ORDER= order;  //"FCBWHJLOAQUXMPVINTKGZERDYS";

        String str[] = s.split("");

        Arrays.sort(str, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return ORDER.indexOf(o1) -  ORDER.indexOf(o2) ;
            }
        });

        return String.valueOf(str);

    }

    public int minPairSum(int[] nums) {


        int size = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                list.add(nums[i]+nums[j]);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        return list.get(0);

    }

    public String addBinary(String a, String b) {

        BigInteger b1 = new  BigInteger(a, 2);
        BigInteger b2 = new  BigInteger(b, 2);

        BigInteger b3 = b1.add(b2);

        return b3.toString(2);

    }

    public String toHex(int num) {

        return Integer.toHexString(num);

    }
}
