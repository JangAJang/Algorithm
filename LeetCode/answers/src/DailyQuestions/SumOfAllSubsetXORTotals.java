package DailyQuestions;

public class SumOfAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums, 0, 0);
    }

    private int subsetXORSumHelper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        int withCurrent = subsetXORSumHelper(nums, index + 1, currentXOR ^ nums[index]);
        int withoutCurrent = subsetXORSumHelper(nums, index + 1, currentXOR);
        return withCurrent + withoutCurrent;
    }
}
