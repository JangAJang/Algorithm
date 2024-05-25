package DailyQuestions;

import java.util.*;

public class WordBreakII {


    private List<List<String>> answer;
    private Map<String, Boolean> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        answer = new ArrayList<>();
        map = createMap(wordDict);
        backTrack(s, 0, new ArrayList<>());
        List<String> resultList = new ArrayList<>();

        for (List<String> innerList : answer) {
            // 각 내부 리스트를 공백으로 연결하여 문자열로 변환
            String joinedString = String.join(" ", innerList);
            // 결과 리스트에 추가
            resultList.add(joinedString);
        }
        return resultList;
    }

    private Map<String, Boolean> createMap(List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        for(String word : wordDict) {
            map.put(word, true);
        }
        return map;
    }

    private void backTrack(String s, int start, List<String> list) {
        if(start == s.length()) {
            answer.add(list);
            return;
        }
        for(int index = start+1; index <= s.length(); index++) {
            String part = s.substring(start, index);
            if(map.getOrDefault(part, false)) {
                List<String> newList = new ArrayList<>(list);
                newList.add(part);
                backTrack(s, index, newList);
            }
        }
    }
}
