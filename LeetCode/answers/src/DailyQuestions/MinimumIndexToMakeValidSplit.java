class Solution {
    public int minimumIndex(List<Integer> nums) { // Accept List<Integer>
        HashMap<Integer, Integer> mp1 = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        for (int num : nums) {
            mp1.put(num, mp1.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.size(); i++) {
            mp1.put(nums.get(i), mp1.get(nums.get(i)) - 1);
            mp2.put(nums.get(i), mp2.getOrDefault(nums.get(i), 0) + 1);

            if (mp1.get(nums.get(i)) * 2 > nums.size() - i - 1 &&
                mp2.get(nums.get(i)) * 2 > i + 1) {
                return i;
            }
        }
        return -1;
    }
}