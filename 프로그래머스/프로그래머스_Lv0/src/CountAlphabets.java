public class CountAlphabets {
    class Solution {

        private final int[] count = new int[52];

        public int[] solution(String my_string) {
            for(char each : my_string.toCharArray()) {
                if( each - 'A' >= 0 && each - 'A' <= 26) {
                    countUpper(each);
                    continue;
                }
                countLower(each);
            }
            return count;
        }

        private void countUpper(char c) {
            count[c - 'A']++;
        }

        private void countLower(char c) {
            count[c - 'a' + 26]++;
        }
    }
}
