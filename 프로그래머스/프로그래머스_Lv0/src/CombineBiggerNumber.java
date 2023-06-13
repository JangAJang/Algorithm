public class CombineBiggerNumber {
    class Solution {
        public int solution(int a, int b) {
            return Math.max(Integer.parseInt(Integer.toString(a) + Integer.toString(b)),
                    Integer.parseInt(Integer.toString(b) + Integer.toString(a)));
        }
    }
}
