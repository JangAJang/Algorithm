import java.util.Arrays;
import java.util.Comparator;

public class SpecialArray {
    // lv0. 특이한 정렬
    class Solution {
        public int[] solution(int[] numlist, int n) {
            return Arrays.stream(numlist).boxed()
                    .sorted(Comparator.reverseOrder())
                    .sorted(Comparator.comparing(s-> Math.abs(n-s)))
                    .mapToInt(Integer::intValue).toArray();
        }
    }
}
