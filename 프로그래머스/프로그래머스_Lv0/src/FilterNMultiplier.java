import java.util.Arrays;

public class FilterNMultiplier {
    //lv0. n의 배수 구하기
    class Solution {
        public int[] solution(int n, int[] numlist) {
            return Arrays.stream(numlist).filter(s-> s%n == 0 && s / n != 0).toArray();
        }
    }
}
