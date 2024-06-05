package DailyQuestions;

import java.util.*;

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        Map[] mapArray = new Map[words.length];

        for(int index = 0; index < words.length; index++) {
            mapArray[index] = countCharacters(words[index]);
        }

        for(char each = 'a'; each <= 'z'; each++) {
            String checkingKey = Character.toString(each);
            int minCount = checkMinimumCount(checkingKey, mapArray);

            while(minCount-- > 0) {
                result.add(checkingKey);
            }
        }


        return result;
    }

    private int checkMinimumCount(String checkingKey, Map[] words) {
        int minCount = Integer.MAX_VALUE;
        for(Map<String, Integer> word : words) {
            int count = word.getOrDefault(checkingKey, 0);
            if(count == 0) return 0;
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    private Map<String, Integer> countCharacters(String word) {
        Map<String, Integer> map = new HashMap<>();

        for(String each : word.split("")) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        return map;
    }
}
