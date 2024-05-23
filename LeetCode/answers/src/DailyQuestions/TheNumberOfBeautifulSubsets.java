package DailyQuestions;

import java.util.*;

public class TheNumberOfBeautifulSubsets {

    public int beautifulSubsets(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);

        int answer = 1, prev = 0, prevPrev = 0;

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            if (m.containsKey(cur - k)) continue;

            prev = 0;

            while (m.containsKey(cur)) {
                prevPrev = prev;
                prev = ((1 << m.get(cur)) - 1) * answer;
                answer += prevPrev;
                cur += k;
            }
            answer += prev;
        }
        return answer - 1;
    }
}
