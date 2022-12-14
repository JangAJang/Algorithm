import java.util.Arrays;
import java.util.regex.Pattern;

public class SumOfHiddenNumberNo1 {
    //lv0. 숨어있는 숫자의 덧셈(1)
    class Solution {

        private static final String PATTERN = "^[0-9]*$";

        public int solution(String my_string) {
            return Arrays.stream(my_string.split(""))
                    .filter(s-> Pattern.matches(PATTERN, s)).mapToInt(Integer::parseInt).sum();
        }
    }
}
