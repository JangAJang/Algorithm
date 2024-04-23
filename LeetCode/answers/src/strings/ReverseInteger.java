package strings;

public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            int result = x > 0 ? 1 : -1;
            result *= flip(Math.abs((long)x));
            return result;
        }

        private int flip(long x) {
            if ( x== 0) {
                return 0;
            }

            StringBuilder sb = new StringBuilder();
            while(x > 0) {
                sb.append(x % 10);
                x /= 10;
            }

            if( Long.parseLong(sb.toString()) > Integer.MAX_VALUE){
                return 0;
            }

            return Integer.parseInt(sb.toString());
        }
    }
}
