package DailyQuestions;

public class LargestPositiveIntegerThatExistsItsNegative {

    public int findMaxK(int[] nums) {
        int answer = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int each : nums) {
            if(!map.containsKey(Math.abs(each))) {
                map.put(Math.abs(each), each);
                continue;
            }
            if(map.get(Math.abs(each)) + each == 0) {
                answer = Math.max(Math.abs(each), answer);
            }
        }
        return answer == Integer.MIN_VALUE ? -1 : answer;
    }
}
