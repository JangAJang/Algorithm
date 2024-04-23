package strings;

public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] sArray = createAlphabetMap(s);
            int[] tArray = createAlphabetMap(t);

            for(int index = 0; index < 26; index++) {
                if( sArray[index] != tArray[index]) return false;
            }

            return true;
        }

        private int[] createAlphabetMap(String x) {
            int[] arr = new int[26];

            for( char each : x.toCharArray()) {
                arr[each - 'a']++;
            }

            return arr;
        }
    }
}
