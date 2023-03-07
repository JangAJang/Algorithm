import java.util.Arrays;

public class CalculateString {
    //lv0. 문자열 계산하기
    class Solution {
        public int solution(String my_string) {
            return Arrays.stream(my_string.replace("+ ", "")
                    .replace("- ", "-").replace("--", "")
                    .split(" ")).mapToInt(Integer::parseInt).sum();
        }
    }
}
