import java.util.Arrays;
import java.util.stream.Collectors;

public class CutArray {
    //lv0. 배열 자르기
    class Solution {
        public int[] solution(int[] numbers, int num1, int num2) {
            return Arrays.stream(numbers).boxed()
                    .collect(Collectors.toList()).subList(num1, num2+1)
                    .stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
