public class IsSuffix {
    class Solution {
        public int solution(String my_string, String is_suffix) {
            if(is_suffix.length() > my_string.length())
                return 0;
            String part = my_string.substring(my_string.length() - is_suffix.length());
            if(part.equals(is_suffix))
                return 1;
            return 0;
        }
    }
}
