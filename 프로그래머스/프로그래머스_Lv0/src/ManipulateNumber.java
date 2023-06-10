public class ManipulateNumber {
    class Solution {
        public int solution(int n, String control) {
            for (char c : control.toCharArray()) {
                n += convertToNumber(c);
            }
            return n;
        }

        private int convertToNumber(char c) {
            if ( c== 'w') return 1;
            if ( c== 's') return -1;
            if ( c== 'd') return 10;
            return -10;
        }
    }
}
