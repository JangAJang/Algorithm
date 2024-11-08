package DailyQuestions;

public class MaximumXORForEachQuery {

	public int[] getMaximumXor(int[] nums, int maximumBit) {
		final int[] answer = new int[nums.length];
		int xorValue = getTarget(maximumBit) ^ nums[0];
		final int n = nums.length;

		for(int index = 1; index < nums.length; index++) {
			answer[n - index] = xorValue;
			xorValue ^= nums[index];
		}
		answer[0] = xorValue;
		return answer;
	}

	private int getTarget(final int maximumBit) {
		return (int) Math.pow(2, maximumBit) - 1;
	}
}
