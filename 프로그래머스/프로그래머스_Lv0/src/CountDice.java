import java.util.Arrays;

public class CountDice {
    //lv0. 주사위의 개수
    class Solution {

        private int result = 1;

        public int solution(int[] box, int n) {
            Arrays.stream(box).forEach(s-> result *= (s / n));
            return result;
        }
    }
}
