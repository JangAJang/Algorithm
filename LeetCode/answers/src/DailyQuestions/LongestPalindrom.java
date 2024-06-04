package DailyQuestions;

import java.util.*;

public class LongestPalindrom {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char each : s.toCharArray()) {
            map.put(each, map.getOrDefault(each, 0)+1);
        }

        int evenCount = 0;
        int oddCount = 0;

        for(char each : map.keySet()) {
            int count = map.get(each);

            if(count % 2 != 0) {
                oddCount = 1;
            }

            evenCount += (count / 2) * 2;
        }

        return oddCount + evenCount;
    }
}
