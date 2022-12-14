public class LambSkewer {
    // lv0. 양꼬치
    class Solution {

        private static final int LAMB_PRICE = 12_000;
        private static final int DRINK_PRICE = 2_000;

        public int solution(int n, int k) {
            return getLambPrice(n) + getDrinkPrice(k - countService(n));
        }

        private int countService(int n){
            return n / 10;
        }

        private int getLambPrice(int n){
            return n * LAMB_PRICE;
        }

        private int getDrinkPrice(int k){
            return k * DRINK_PRICE;
        }
    }
}
