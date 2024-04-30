package DailyQuestions;

import java.util.*;

public class NumbersOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        long result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int bitmask = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            bitmask ^= (1 << index);
            result += count.getOrDefault(bitmask, 0);

            for (int i = 0; i < 10; i++) {
                int diff = bitmask ^ (1 << i);
                result += count.getOrDefault(diff, 0);
            }
            
            count.put(bitmask, count.getOrDefault(bitmask, 0) + 1);
        }

        return result;
    }
}
