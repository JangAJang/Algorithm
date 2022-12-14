public class DistinguishPowerNumber {
    //lv0. 제곱수 판별하기
    class Solution {
        public int solution(int n) {
            if(n % Math.sqrt(n) == 0) return 1;
            return 2;
        }
    }
}
