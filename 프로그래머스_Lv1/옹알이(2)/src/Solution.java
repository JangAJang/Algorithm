import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static final String[] words = new String[]{"aya", "ye", "woo", "ma"};
    private List<String> spokenWords = new ArrayList<>();
    public int solution(String[] babbling) {
        return countBabblable(babbling);
    }

    private int countBabblable(String[] babbling){
        int count = 0;
        for(String word : babbling){
            count += checkBabblability(word);
        }
        return count;
    }

    private int checkBabblability(String word){
        if(word.startsWith("aya")) {
            spokenWords.add("aya");
            if(!word.substring(3).startsWith("aya")) return checkBabblability(word.substring(3));
        }
        if(word.startsWith("ye")) {
            spokenWords.add("ye");
            if(!word.substring(2).startsWith("ye")) return checkBabblability(word.substring(2));

        }
        if(word.startsWith("woo")) {
            spokenWords.add("woo");
            if(!word.substring(3).startsWith("woo")) return checkBabblability(word.substring(3));
        }
        if(word.startsWith("ma")) {
            spokenWords.add("ma");
            if(!word.substring(2).startsWith("ma")) return checkBabblability(word.substring(2));
        }
        if(word.equals("")) return 1;
        return 0;
    }
}