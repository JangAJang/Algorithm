package DailyQuestions;

public class SortTheJumbledNumber {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> originalIndex = new HashMap<>();
        Map<Integer, Integer> mappingResult = new HashMap<>();
        Integer[] indices = new Integer[nums.length];

        for(int index = 0; index < nums.length; index++) {
            originalIndex.put(nums[index], index);
            mappingResult.put(nums[index], getMappedValue(nums[index], mapping));
            indices[index] = nums[index];
        }

        Arrays.sort(indices, (a, b) -> {
            int mappedValueA = mappingResult.get(a);
            int mappedValueB = mappingResult.get(b);
            if (mappedValueA != mappedValueB) {
                return mappedValueA - mappedValueB;
            } else {
                return originalIndex.get(a) - originalIndex.get(b);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = indices[i];
        }

        return nums;
    }

    private int getMappedValue(int value, int[] nums) {
        String result = "";
        for(String each : Integer.toString(value).split("")) {
            result += Integer.toString(nums[Integer.parseInt(each)]);
        }

        return Integer.parseInt(result);
    }
}
