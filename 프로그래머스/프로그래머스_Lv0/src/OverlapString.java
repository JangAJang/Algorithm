public class OverlapString {
    class Solution {
        public String solution(String my_string, String overwrite_string, int s) {
            StringBuilder sb = new StringBuilder();
            for(int index = 0; index < s; index++){
                sb.append(my_string.charAt(index));
            }
            for(int index = s; index < overwrite_string.length()+s; index++){
                sb.append(overwrite_string.charAt(index-s));
            }
            for(int index = overwrite_string.length()+s; index < my_string.length(); index++){
                sb.append(my_string.charAt(index));
            }
            return sb.toString();
        }
    }
}
