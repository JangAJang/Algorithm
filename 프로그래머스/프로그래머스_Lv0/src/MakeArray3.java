import java.util.*;

public class MakeArray3 {
    class Solution {

        private final List<Integer> list = new ArrayList<>();

        public int[] solution(int[] arr, int[][] intervals) {
            for(int[] interval : intervals) {
                addInterval(interval[0], interval[1], arr);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        private void addInterval(int from, int to, int[] arr) {
            for(int index = from; index <= to; index++) {
                list.add(arr[index]);
            }
        }
    }
}
