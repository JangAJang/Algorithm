public class SeparatePizzaNo3 {
    //lv0. 피자 나눠먹기 (3)
    class Solution {
        public int solution(int slice, int n) {
            return countPizzaForEachPortion(slice, n);
        }

        private int countPizzaForEachPortion(int slice, int n){
            for(int pizzaCount = 1; ; pizzaCount++){
                if(pizzaCount*slice / n >= 1) return pizzaCount;
            }
        }
    }
}
