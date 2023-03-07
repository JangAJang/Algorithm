public class ChickenCoupon {
    // lv0. 치킨 쿠폰
    class Solution {
        public int solution(int chicken) {
            int service = 0;
            int coupon = chicken;
            while(coupon >= 10){
                service += coupon / 10;
                coupon = coupon / 10 + coupon % 10;
            }
            return service;
        }
    }
}
