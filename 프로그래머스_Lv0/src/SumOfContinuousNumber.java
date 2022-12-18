import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumOfContinuousNumber {
    // lv0. 연속된 수의 합
    class Solution {
        public int[] solution(int num, int total) {
            int firstNumber = (total - IntStream.range(0, num).sum()) / num;
            return IntStream.range(firstNumber, firstNumber+num).toArray();
        }
    }
}
