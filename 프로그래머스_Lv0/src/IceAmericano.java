public class IceAmericano {
    //lv0. 아이스 아메리카노
    class Solution {

        private static final int AMERICANO_PRICE = 5_500;
        public int[] solution(int money) {
            return new int[]{money / AMERICANO_PRICE, money % AMERICANO_PRICE};
        }
    }
}
