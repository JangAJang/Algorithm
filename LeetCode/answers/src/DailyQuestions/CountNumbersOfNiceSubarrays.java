package DailyQuestions;

public class CountNumbersOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        counts.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num % 2;
            if (counts.containsKey(prefixSum - k)) {
                count += counts.get(prefixSum - k);
            }
            counts.put(prefixSum, counts.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
