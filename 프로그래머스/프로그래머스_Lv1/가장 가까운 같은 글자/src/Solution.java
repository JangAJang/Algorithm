import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> indexMap = new HashMap<>();
        Map<Character, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            if (!indexMap.containsKey(s.charAt(i))) {
                indexMap.put(s.charAt(i), i);
                distanceMap.put(s.charAt(i), -1);
                answer[i] = -1;
                continue;
            }
            distanceMap.put(s.charAt(i), i - indexMap.get(s.charAt(i)));
            indexMap.put(s.charAt(i), i);
            answer[i] = distanceMap.get(s.charAt(i));
        }
        return answer;
    }
}