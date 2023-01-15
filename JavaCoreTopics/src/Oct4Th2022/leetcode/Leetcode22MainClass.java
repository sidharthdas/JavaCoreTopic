package Oct4Th2022.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  15/01/23
 */
public class Leetcode22MainClass {

    public static void main(String[] args) {

    }
}

class MagicDictionary {

    List<String> words;

    public MagicDictionary() {
        words = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary){
            words.add(word);
        }
    }

    public boolean search(String searchWord) {
        if(words.contains(searchWord)){
            return false;
        }
        int lenOfSearchWord = searchWord.length();

        List<String> searchList = words.stream().filter(x -> x.length() == lenOfSearchWord)
                .toList();

        for(String word : searchList){
            int count = 0;
            for(int i=0; i < lenOfSearchWord; i++){
                if(count < 2){
                    if(word.charAt(i) != searchWord.charAt(i)){
                        count ++;
                    }
                }else{
                    count = 0;
                    break;
                }
            }

            if(count == 1){
                return true;
            }
        }

        return false;
    }
}
