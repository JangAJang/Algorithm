package strings;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            String alphabets = deleteUselessChar(s.toLowerCase());
            int left = 0;
            int right = alphabets.length()-1;

            while(left <= right) {
                if( alphabets.charAt(left) != alphabets.charAt(right))
                    return false;
                left++;
                right--;
            }

            return true;
        }

        private String deleteUselessChar(String s) {
            StringBuilder sb = new StringBuilder();

            for(char each : s.toCharArray()) {
                if( each - '0' >=0 && each - '0' <= 9) {
                    sb.append(each);
                }

                if( each - 'a' >= 0 && each - 'a' < 26) {
                    sb.append(each);
                }
            }

            return sb.toString();
        }
    }
}
