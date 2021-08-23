package JavaCoreTopicsImplementation17thJul2021.practice.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sidharthdas on 18/08/21.
 */


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode ( int val ) {
        this.val = val;
    }

    TreeNode ( int val, TreeNode left, TreeNode right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BST{

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        l.add(root.val);
        inOrder(root.right);
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        if(left > right ){
            return left +1;
        }else{
            return right+1;
        }
    }
}

public class LeetCodeDesignQues {


    public static void main ( String[] args ) {//Sid

        new LeetCodeDesignQues().test(16);

    }


    public boolean test ( int n ) {
        List< Integer > list = new ArrayList<>();

        while (n % 2 == 0) {
            list.add(2);
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                list.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            list.add(n);


        Map< Integer, Integer > map = new HashMap<>();

        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;


    }

    public boolean isPerfectSquare ( int num ) {
        List< Integer > list = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                list.add(i);
        }

        Map< Integer, Integer > map = new HashMap<>();

        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry< Integer, Integer > m : map.entrySet()) {
            if (m.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;

    }


    public boolean checkStraightLine ( int[][] coordinates ) {


        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        int count = 0;
        for (int[] i : coordinates) {
            if (count == 0) {
                if(i[0] != 0 && i[1] != 0) {
                    x1 = i[0];
                    y1 = i[1];
                    count++;
                }
            } else if (count == 1) {
                if(i[0] != 0 && i[1] != 0) {
                    x2 = i[0];
                    y2 = i[1];
                    count++;
                }
            } else {
                break;
            }
        }


        int m = (y2 - y1) / (x2 - x1);

        int c = y1 - (m * x1);

        for (int[] i : coordinates) {
            if (i[1] != (m * i[0] + c)) {
                return false;
            }
        }

        return true;
    }

    public boolean isUnivalTree(TreeNode root) {

       BST  b = new BST();
       b.inOrder(root);

       return b.l.stream().collect(Collectors.toSet()).size() == 1 ?  true : false;




    }
}
