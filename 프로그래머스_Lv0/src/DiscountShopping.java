public class DiscountShopping {
    //lv0. 옷가게 할인받기
    class Solution {
        public int solution(int price) {
            if(price >= 500_000) return (int) (price * 0.8);
            if(price >= 300_000) return (int) (price * 0.9);
            if(price >= 100_000) return (int) (price * 0.95);
            return price;
        }
    }
}
