package DailyQuestions;

public class MaximumNumberOf3NonOverlappingSubarrays {

	class Solution {
		int[][] dp = new int[100000][4];
		public int F(int idx, int[] K_Size_windowSum, int k, int left) {
			if (idx >= K_Size_windowSum.length) {
				return (left == 0) ? 0 : Integer.MIN_VALUE;
			}
			if (left < 0) {
				return Integer.MIN_VALUE;
			}
			if (dp[idx][left] != -1) {
				return dp[idx][left];
			}
			int take_ith_index = K_Size_windowSum[idx] + F(idx + k, K_Size_windowSum, k, left - 1);
			int not_take_ith_index = F(idx + 1, K_Size_windowSum, k, left);
			return dp[idx][left] = Math.max(take_ith_index, not_take_ith_index);
		}

		public void recover(int[] K_Size_windowSum, int k, int idx, int t, List<Integer> res) {
			if (idx >= K_Size_windowSum.length || t == 0) {
				return;
			}
			int take_ith_index = K_Size_windowSum[idx] + F(idx + k, K_Size_windowSum, k, t - 1);
			int not_take_ith_index = F(idx + 1, K_Size_windowSum, k, t);
			if (take_ith_index >= not_take_ith_index) {
				res.add(idx);
				recover(K_Size_windowSum, k, idx + k, t - 1, res);
			} else {
				recover(K_Size_windowSum, k, idx + 1, t, res);
			}
		}

		public int[] maxSumOfThreeSubarrays(int[] A, int k) {
			for (int[] row : dp) {
				Arrays.fill(row, -1);
			}
			int n = A.length;
			int[] P = new int[n];
			P[0] = A[0];
			for (int i = 1; i < A.length; i++) {
				P[i] = P[i - 1] + A[i];
			}
			int[] K_Size_windowSum = new int[n - k + 1];
			for (int i = 0; i <= n - k; i++) {
				if (i == 0) {
					K_Size_windowSum[0] = P[k - 1];
				} else {
					K_Size_windowSum[i] = P[i + k - 1] - P[i - 1];
				}
			}
			List<Integer> result = new ArrayList<>();
			F(0, K_Size_windowSum, k, 3);
			recover(K_Size_windowSum, k, 0, 3, result);
			int[] resArray = new int[result.size()];
			for (int i = 0; i < result.size(); i++) {
				resArray[i] = result.get(i);
			}
			return resArray;
		}
	}
}
