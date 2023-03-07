public class SeparatePizzaNo1 {
    // lv0. 피자 나눠먹기(1)
    class Solution {

        private static final int PORTION_PER_PIZZA = 7;

        public int solution(int n) {
            return countEnoughPizza(n);
        }

        private int countEnoughPizza(int n){
            for(int index = 1; ; index++){
                if(PORTION_PER_PIZZA * index / n >= 1) return index;
            }
        }
    }
}
