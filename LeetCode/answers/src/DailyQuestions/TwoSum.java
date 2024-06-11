package DailyQuestions;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }

        for(int index = 0; index < nums.length; index++) {
            int value = target - nums[index];
            if(map.containsKey(value)) {
                if(index == map.get(value)) continue;
                return new int[]{ index, map.get(value) };
            }
        }

        return new int[]{-1};
    }
}
