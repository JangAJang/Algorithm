public class SumOfFranction {
    // lv0. 분수의 덧셈
    class Solution {
        public int[] solution(int denum1, int num1, int denum2, int num2) {
            int number = denum1 * num2 + denum2 * num1;
            int fraction = num1*num2;
            return new int[]{number / gcd(number, fraction), fraction / gcd(number, fraction)};
        }

        private int gcd(int number, int fraction){
            int r = number % fraction;
            if(r == 0 ) return fraction;
            return gcd(fraction, r);
        }
    }
}
