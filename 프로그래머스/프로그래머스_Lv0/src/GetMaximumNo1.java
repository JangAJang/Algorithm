import java.util.*;
import java.util.stream.Collectors;

public class GetMaximumNo1 {
    //lv0. 최댓값 만들기(1)
    class Solution {
        public int solution(int[] numbers) {
            return getMultiplyOfBiggestTwo(sortNumbers(numbers));
        }

        private List<Integer> sortNumbers(int[] numbers){
            return Arrays.stream(numbers).boxed()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

        private int getMultiplyOfBiggestTwo(List<Integer> numbers){
            return numbers.get(0) * numbers.get(1);
        }
    }
}
