public class SeparatePizzaNo2 {
    // lv0. 피자 나눠 먹기(2)
    class Solution {

        private static final int SLICE_PER_PIZZA = 6;

        public int solution(int n) {
            return n / gcd(n, SLICE_PER_PIZZA);
        }

        private int gcd(int a, int b) {
            int r = a - (a / b) * b;
            if (r != 0) {
                return gcd(b, r);
            }
            return b;
        }
    }
}
