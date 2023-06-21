public class MultiplyString {
    class Solution {
        public String solution(String my_string, int k) {
            StringBuilder sb = new StringBuilder();
            for(int index = 0; index < k; index ++) {
                sb.append(my_string);
            }
            return sb.toString();
        }
    }
}
