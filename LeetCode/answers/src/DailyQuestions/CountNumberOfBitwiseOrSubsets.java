package DailyQuestions;

public class CountNumberOfBitwiseOrSubsets {

    private int max;
    private int count;

    public int countMaxOrSubsets(int[] nums) {
        max = getMaxOr(nums);
        count = 0;

        countMax(nums, 0, -1);

        return count;
    }

    private void countMax(final int[] nums, final int current, final int start) {
        for(int index = start + 1; index < nums.length; index++) {
            final int value = current | nums[index];
            if(value == max) count++;
            countMax(nums, value, index);
        }
    }

    private int getMaxOr(final int[] nums) {
        int answer = 0;
        for(int num : nums) {
            answer |= num;
        }

        return answer;
    }
}
