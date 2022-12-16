import java.util.Arrays;

public class Game369 {
    // lv0. 369게임
    class Solution {
        public int solution(int order) {
            return (int)Arrays.stream(Integer.toString(order).split("")).filter(s-> Integer.parseInt(s)%3 == 0 && !s.equals("0")).count();
        }
    }
}
