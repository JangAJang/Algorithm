import java.util.Arrays;

public class SumEachNumber {
    //lv0. 자릿수 더하기
    class Solution {
        public int solution(int n) {
            return Arrays.stream(String.valueOf(n)
                    .split("")).mapToInt(Integer::parseInt).sum();
        }
    }
}
