package JUNE.practice23rdJuly.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*/
   @author sidharthdas on 25/07/21.
  /*/

class TreeNode {
int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
public class Leetcode25July {


    public static void main ( String[] args ) {

    }

    public int sumOddLengthSubarrays(int[] arr) {

        int arrSize = arr.length;
        //start point
        List< List<Integer> > list = new ArrayList<>();
        for (int startPoint = 0; startPoint <arrSize ; startPoint++) {
            //group sizes

            for (int grps = startPoint; grps <=arrSize ; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                List<Integer> list1 = new ArrayList<>();
                for (int j = startPoint ; j < grps ; j++) {
                    System.out.print(arr[j] + " ");
                    list1.add(arr[j]);
                }
                list.add(list1);
                System.out.println();
            }
        }
        System.out.println(list);

        List<List<Integer>> mainList = list.stream().filter(x -> x.size() % 2 !=0).collect(Collectors.toList());
        int total = 0;
        for(List<Integer> l : mainList) {

            if(l.size()>0){
                for(int i : l){
                    total+=i;
                }
        }

    }
        return total;

    }

    public int uniqueMorseRepresentations(String[] words) {

        List<String> codeList = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
        List< String > alphaList = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        List<String> list = new ArrayList<>();

        for(String s : words){
            String str[] = s.split("");
            String newS = "";
            for(String s1 : str){
                int index = alphaList.indexOf(s1);
                newS += codeList.get(index);
            }
            list.add(newS);
        }

        int size = list.stream().collect(Collectors.toSet()).size();
        return size;


    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        BST B = new BST();
        B.inOrder(root1);
        List<Integer> l1 = B.l;


        BST B1 = new BST();
        B1.inOrder(root2);
        List<Integer> l2 = B1.l;

        l1.addAll(l2);

        return l1;


    }

    public boolean squareIsWhite(String coordinates) {

        List<String> ifNumberIsEvenThenItsWhite = Arrays.asList("a","c","e","g");
        List<String> ifNumberIsOddThenItsWhite = Arrays.asList("a","c","e","g");

        String str[] = coordinates.split("");

        if(ifNumberIsEvenThenItsWhite.contains(str[0])){
            return Integer.valueOf(str[1]) % 2 ==0 ? true : false;
        }else if(ifNumberIsOddThenItsWhite.contains(str[0])){
            return Integer.valueOf(str[1]) % 2 ==0 ? false : true;
        }

        return false;
    }



}


class BST{

    List<Integer> l = new ArrayList<>();

    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        l.add(node.val);
        inOrder(node.right);

    }
}
