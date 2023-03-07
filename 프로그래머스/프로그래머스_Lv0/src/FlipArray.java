import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlipArray {
    //lv0. 배열 뒤집기
    class Solution {
        public int[] solution(int[] num_list) {
            return flipArray(num_list);
        }

        private int[] flipArray(int[] num_list){
            List<Integer> numbers = Arrays.stream(num_list).boxed().collect(Collectors.toList());
            Collections.reverse(numbers);
            return numbers.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
