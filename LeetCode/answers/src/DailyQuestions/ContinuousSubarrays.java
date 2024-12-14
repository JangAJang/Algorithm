package DailyQuestions;

public class ContinuousSubarrays {

	public long continuousSubarrays(int[] nums) {
		int l = 0;
		long res = 0;
		Deque<Integer> minD = new LinkedList<>(), maxD = new LinkedList<>();

		for (int r = 0; r < nums.length; r++) {
			while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
				minD.pollLast();
			}
			while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
				maxD.pollLast();
			}

			minD.offerLast(r);
			maxD.offerLast(r);

			while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > 2) {
				l++;
				if (minD.peekFirst() < l) minD.pollFirst();
				if (maxD.peekFirst() < l) maxD.pollFirst();
			}

			res += r - l + 1;
		}

		return res;
	}
}
