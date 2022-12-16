import java.util.Arrays;

public class MakeMaximumNo2 {
    // lv0. 최댓값 만들기(2)
    class Solution {
        public int solution(int[] numbers) {
            Arrays.sort(numbers);
            return Math.max(numbers[0]*numbers[1], numbers[numbers.length-1]*numbers[numbers.length-2]);
        }
    }
}
