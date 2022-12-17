import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MakeRanking {
    // lv0. 등수 매기기
    class Solution {
        public int[] solution(int[][] score) {
            List<Integer> medium = Arrays.stream(score).mapToInt(array-> array[0]+array[1])
                    .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            return Arrays.stream(score).mapToInt(array-> medium.indexOf(array[0]+array[1])+1).toArray();
        }
    }
}
