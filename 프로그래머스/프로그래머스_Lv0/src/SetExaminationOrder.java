import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SetExaminationOrder {
    // lv0. 진료 순서 정하기
    class Solution {
        public int[] solution(int[] emergency) {
            List<Integer> order = Arrays.stream(emergency)
                    .boxed().collect(Collectors.toList())
                    .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return Arrays.stream(emergency).map(s-> order.indexOf(s)+1).toArray();
        }
    }
}
