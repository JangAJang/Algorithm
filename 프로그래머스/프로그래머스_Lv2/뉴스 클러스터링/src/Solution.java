import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

class Solution {

    public int solution(String str1, String str2) {
        HashMap<String, Integer> cases1 = addCases(str1.toLowerCase());
        HashMap<String, Integer> cases2 = addCases(str2.toLowerCase());
        return getZacadSimilarity(cases1, cases2);
    }

    private int getZacadSimilarity(HashMap<String, Integer> cases1, HashMap<String, Integer> cases2){
        if(cases1.isEmpty() && cases2.isEmpty()) return 65536;
        int commonCount = countInCommon(cases1, cases2);
        return 65536 * commonCount / (getTotalCount(cases1) + getTotalCount(cases2) - commonCount);
    }

    private int getTotalCount(HashMap<String, Integer> map){
        int result = 0;
        for(String keyEach : map.keySet()){
            result += map.get(keyEach);
        }
        return result;
    }

    private int countInCommon(HashMap<String, Integer> cases1, HashMap<String, Integer> cases2){
        int totalCount = 0;
        for(String cases1word : cases1.keySet()){
            if(cases2.containsKey(cases1word)) totalCount += Math.min(cases1.get(cases1word), cases2.get(cases1word));
        }
        return totalCount;
    }

    private HashMap<String, Integer> addCases(String words){
        HashMap<String, Integer> countLetters = new HashMap<>();
        for(int index = 0; index < words.length()-1; index++){
            String wordEach = words.substring(index, index+2);
            if(isEnglish(wordEach)) addToMap(wordEach, countLetters);
        }
        return countLetters;
    }

    private boolean isEnglish(String word){
        return Pattern.matches("^[a-z]*$", word);
    }

    private void addToMap(String wordEach, HashMap<String, Integer> countLetters){
        if(countLetters.containsKey(wordEach)){
            countLetters.replace(wordEach, countLetters.get(wordEach), countLetters.get((wordEach))+1);
            return;
        }
        countLetters.put(wordEach, 1);
    }
}