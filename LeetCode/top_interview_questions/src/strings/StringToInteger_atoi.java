package strings;

public class StringToInteger_atoi {

    class Solution {
        public int myAtoi(String s) {
            String str = s.stripLeading().split("\\s+")[0];

            if (str.length() == 0) {
                return 0;
            }

            if (str.charAt(0) == '+') {
                return convert(str.substring(1), false);
            }

            if (str.charAt(0) == '-') {
                return convert(str.substring(1), true);
            }

            if (Character.isDigit(str.charAt(0))) {
                return convert(str, false);
            }

            return 0;
        }

        private int convert(String s, boolean isNegative) {
            long value = 0;

            for (int idx = 0; idx < s.length() && Character.isDigit(s.charAt(idx)); idx++) {
                value = value * 10 + Character.getNumericValue(s.charAt(idx));

                if (value > Integer.MAX_VALUE) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }

            return (int) (isNegative ? -value : value);
        }
    }

}
