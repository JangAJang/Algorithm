package DailyQuestions;

import java.util.*;

public class MinimumIncreaseToMakeArrayUnique {

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int answer = 0;

        for(int index = 1; index < nums.length; index++) {
            if(nums[index] > nums[index-1]) continue;
            answer += nums[index-1] + 1 - nums[index];
            nums[index] = nums[index-1]+1;
        }

        return answer;
    }
}
