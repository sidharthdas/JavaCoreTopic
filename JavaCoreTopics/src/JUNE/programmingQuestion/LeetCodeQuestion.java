package JUNE.programmingQuestion;

import java.util.Objects;

/**
 * @author sidharthdas on 02/07/21.
 */
public class LeetCodeQuestion {

    public static void main ( String[] args ) {



        LeetCodeQuestion leetCodeQuestion = new LeetCodeQuestion();

        System.out.println(leetCodeQuestion.isValid(null));


    }

    public boolean isValid(String s) {
        if(Objects.isNull(s)){
            return false;
        }

        String[] srr = s.split("");

        boolean flag= true;

        if(srr.length % 2 != 0){
            return false;
        }

        for(int i = 0; i < srr.length; ){

           String s1 = respectiveBracket(srr[i]);
           if(!srr[i+1].equals(s1)){
               flag = false;
               break;
           }
           i = i+2;
        }
        return flag;



    }

    private String respectiveBracket(String s) {

        String brack = null;

        switch (s) {

            case "(":
                brack = ")";
               break;
            case "{":
                brack = "}";
                break;
            case "[":
                brack = "]";
                break;
            default:
                brack = null;
                break;


        }

        return brack;
    }
}
