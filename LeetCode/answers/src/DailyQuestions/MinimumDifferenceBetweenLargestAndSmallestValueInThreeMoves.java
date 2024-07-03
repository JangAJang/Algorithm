package DailyQuestions;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {

    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        Arrays.sort(nums);

        int value = Integer.MAX_VALUE;
        for(int index = 0; index < 4; index++) {
            int start = index;
            int end = nums.length - (4-index);
            value = Math.min(value, nums[end] - nums[start]);
        }

        return value;
    }
}
