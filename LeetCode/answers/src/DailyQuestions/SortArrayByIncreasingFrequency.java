package DailyQuestions;

public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqA = map.get(a);
                int freqB = map.get(b);
                if (freqA == freqB) {
                    return b - a;
                }
                return freqA - freqB;
            }
        });

        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }
}
