package DailyQuestions;

public class FindIfArrayCanBeSorted {

	public boolean canSortArray(int[] nums) {
		if(isSorted(nums)) return true;

		for(int index = 0; index < nums.length-1; index++) {
			final int left = nums[index];
			final int right = nums[index+1];

			if(left <= right) continue;

			if(countBit(left) != countBit(right)) return false;
			nums[index+1] = left;
			nums[index] = right;

			return canSortArray(nums);
		}

		return true;
	}

	private int countBit(final int value) {
		int n = value;
		int count = 0;
		while (n != 0) {
			n &= (n - 1); // 가장 오른쪽 1 비트를 제거
			count++;
		}
		return count;
	}

	private boolean isSorted(final int[] nums) {
		for(int index = 0; index < nums.length-1; index++) {
			if(nums[index] > nums[index+1]) return false;
		}

		return true;
	}
}
