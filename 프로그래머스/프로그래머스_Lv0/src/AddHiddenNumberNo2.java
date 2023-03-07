import java.util.Arrays;
import java.util.regex.Pattern;

public class AddHiddenNumberNo2 {
    // lv0. 숨어있는 숫자의 덧셈(2)
    class Solution {
        public int solution(String my_string) {
            return Arrays.stream(my_string.replaceAll("[^0-9]", " ")
                    .split(" ")).filter(s-> Pattern.matches("^[0-9]*$", s) && !s.equals(""))
                    .mapToInt(Integer::parseInt).sum();
        }
    }
}
