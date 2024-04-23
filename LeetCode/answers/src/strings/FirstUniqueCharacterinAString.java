package strings;

import java.util.*;

public class FirstUniqueCharacterinAString {

    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();

            for(char each : s.toCharArray()) {
                map.put(each, map.getOrDefault(each, 0)+1);
            }

            int answer = Integer.MAX_VALUE;

            for(char key : map.keySet()) {
                if( map.get(key) == 1) {
                    answer = Math.min(answer, s.indexOf(key));
                }
            }

            if( answer == Integer.MAX_VALUE)
                answer = -1;

            return answer;
        }
    }
}
