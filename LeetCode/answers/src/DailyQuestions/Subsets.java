package DailyQuestions;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int max = Integer.parseInt("1" + "0".repeat(nums.length), 2);
        for(int count = 0; count < max; count++) {
            // 각 비트연산자의 값을 순회한다.
            List<Integer> cases = new ArrayList<>();
            String bitCount = Integer.toString(count, 2);
            for(int index = 0; index < bitCount.length(); index++) {
                int bitIndex = bitCount.length() - 1 - index;
                if(bitCount.charAt(bitIndex) == '1') {
                    cases.add(nums[index]);
                }
            }
            answer.add(cases);
        }
        return answer;
    }
}
