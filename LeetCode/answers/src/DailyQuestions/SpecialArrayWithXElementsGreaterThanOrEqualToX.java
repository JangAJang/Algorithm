package DailyQuestions;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualToX {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int answer = -1;
        for(int index = 1; index <= nums.length; index++) {
            int count = countPossibleArray(nums, index);
            if(count == index) answer = Math.max(answer, count);
        }
        return answer;
    }

    private int countPossibleArray(int[] nums, int expectedLength) {
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] >= expectedLength) return nums.length - index;
        }
        return -1;
    }
}
