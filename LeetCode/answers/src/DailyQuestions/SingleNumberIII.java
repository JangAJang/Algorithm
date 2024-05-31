package DailyQuestions;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int diff = xor & -xor;

        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
                continue;
            }

            result[1] ^= num;
        }

        return result;
    }
}
