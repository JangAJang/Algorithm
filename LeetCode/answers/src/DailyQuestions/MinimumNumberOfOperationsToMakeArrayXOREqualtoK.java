package DailyQuestions;

public class MinimumNumberOfOperationsToMakeArrayXOREqualtoK {

    public int minOperations(int[] nums, int k) {
        for(int each : nums) {
            k ^= each;
        }
        int count = 0;
        for(char each : Integer.toBinaryString(k).toCharArray()) {
            if(each == '1') count++;
        }
        return count;
    }
}
