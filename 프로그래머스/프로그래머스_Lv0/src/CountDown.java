import java.util.*;
import java.util.stream.*;

public class CountDown {
    class Solution {
        public int[] solution(int start, int end) {
            int[] arr = new int[start-end+1];
            IntStream.range(0, start-end+1).forEach(i -> arr[i] = start - i);
            return arr;
        }
    }
}
