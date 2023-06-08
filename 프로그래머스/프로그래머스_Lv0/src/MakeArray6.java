import java.util.Stack;
import java.util.stream.IntStream;

public class MakeArray6 {
    class Solution {
        private final Stack<Integer> stack = new Stack<>();
        public int[] solution(int[] arr) {
            IntStream.range(0, arr.length).forEach(i -> useValue(arr[i]));
            if(stack.isEmpty()) return new int[]{-1};
            return stack.stream().mapToInt(Integer::intValue).toArray();
        }

        private void useValue(int value) {
            if(stack.isEmpty()) {
                stack.push(value);
                return;
            }
            if(stack.peek() == value) {
                stack.pop();
                return;
            }
            stack.push(value);
        }
    }
}
