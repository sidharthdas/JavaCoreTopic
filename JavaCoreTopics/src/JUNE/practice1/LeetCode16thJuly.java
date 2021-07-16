package JUNE.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sidharthdas on 16/07/21.
 */



   class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class BST2{

       List<Integer> list = new ArrayList<>();

       public void inOrder(TreeNode1 node){
           if(node == null){
               return;
           }
           inOrder(node.left);
           list.add(node.val);
           inOrder(node.right);
       }
  }

public class LeetCode16thJuly {

    public static void main ( String[] args ) {

        String word1 = "abcd", word2 = "pq";


        LeetCode16thJuly leetCode16thJuly = new LeetCode16thJuly();
        System.out.println(leetCode16thJuly.mergeAlternately(word1, word2));


    }

    public int[] sortArrayByParityII ( int[] nums ) {

        int numSize = nums.length;

        int[] res = new int[numSize];

        int evenIndex = 0;
        int oddIndex = 1;

        for (int i = 0; i < numSize; i++) {
            if (nums[i] % 2 == 0) {
                res[evenIndex] = nums[i];
                evenIndex += 2;
            } else if (nums[i] % 2 != 0) {
                res[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return res;
    }

    public String mergeAlternately ( String word1, String word2 ) {


        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 > len2) {
            String res = "";
            String s1 = word1.substring(0, word2.length());
            String s2 = word1.substring(word2.length(), word1.length());

            String s1tr[] = s1.split("");

            for (int i = 0; i < len2; i++) {
                res += s1.charAt(i) + "" + word2.charAt(i) + "";
            }

            res += s2;

            return res;

        } else if (len1 < len2) {

            String res = "";
            String s1 = word2.substring(0, word1.length());
            String s2 = word2.substring(word1.length(), word2.length());

            String s1tr[] = s1.split("");

            for (int i = 0; i < len1; i++) {
                res += word1.charAt(i) + "" + s1.charAt(i) + "";
            }

            res += s2;

            return res;

        } else {

            String res = "";
            System.out.println(word1);
            System.out.println(word2);
            for (int i = 0; i < len2; i++) {
                res += word1.charAt(i) + "" + word2.charAt(i) + "";
            }

            return res;

        }
    }

    public String reverseStr ( String s, int k ) {

        String s1 = s.substring(0, k);

        String s2 = s.substring(k, s.length());

        String s3 = "";
        for (int i = k - 1; i >= 0; i--) {
            s3 += s1.charAt(i) + "";
        }
        return s3 + s2 + "";
    }

    public boolean checkIfExist ( int[] arr ) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i != j) {
                    if (arr[i] == 2 * arr[j]) {

                        return true;
                    }
                }
            }


        }
        return false;
    }

    public String reverseVowels ( String s ) {
        List< String > vowels = Arrays.asList("a", "e", "i", "o", "u");

        List< String > vowelsInString = new ArrayList<>();

        String[] st = s.split("");
        int size = st.length;
        int index = 0;
        int ress = 0;

        for (int i = 0; i < size; i++) {
            if (vowels.contains(st[i])) {
                vowelsInString.add(st[i]);
                st[i] = index + "";
                index += 1;
            }
        }
        List< String > revVowelsInString = new ArrayList<>();
        int vSize = vowelsInString.size();

        for(int i = vSize-1; i >=0; i--){
            revVowelsInString.add(vowelsInString.get(i));
        }

        for(int i = 0; i < size; i++){
            if(st[i].equals(String.valueOf(ress))){
                st[i] = revVowelsInString.get(ress);
                ress+=1;
            }
        }
        String finalRes = "";
        for(String s1 : st){
            finalRes+= s1;
        }
        return finalRes;
    }


    public boolean findTarget(TreeNode1 root, int k) {

        BST2 b = new BST2();

        b.inOrder(root);

        int size = b.list.size();

        for(int i = 0; i < size; i++){
            int j = k = b.list.get(i);

            if(b.list.contains(j)){
                return true;
            }
        }

        return false;
    }
}
