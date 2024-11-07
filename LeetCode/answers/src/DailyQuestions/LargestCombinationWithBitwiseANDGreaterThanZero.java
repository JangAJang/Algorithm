package DailyQuestions;

public class LargestCombinationWithBitwiseANDGreaterThanZero {

	private Map<Integer, Integer> map;

	public int largestCombination(int[] candidates) {
		map = new HashMap<>();
		for(int each : candidates) {
			addToMap(each);
		}

		int answer = 0;
		for(int key : map.keySet()) {
			answer = Math.max(answer, map.get(key));
		}

		return answer;
	}

	private void addToMap(final int value) {
		int each = 1;
		while(each <= value) {
			final int andValue = each & value;
			if(andValue == 0) {
				each *= 2;
				continue;
			}
			map.put(each, map.getOrDefault(each, 0)+1);
			each *= 2;
		}
	}
}
