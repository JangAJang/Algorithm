import java.util.Arrays;
import java.util.regex.Pattern;

public class UpperAndLower {
    //lv0. 대문자와 소문자
    class Solution {
        public String solution(String my_string) {
            StringBuilder stringBuilder = new StringBuilder();
            for(char charEach : my_string.toCharArray()) stringBuilder.append(changeLetter(charEach));
            return stringBuilder.toString();
        }

        private char changeLetter(char each){
            if(isUpper(each)) return (char) ('a' + (each - 'A'));
            return (char) ('A' + (each - 'a'));
        }

        private boolean isUpper(char letter){
            return letter <= 'Z' && letter >= 'A';
        }
    }
}
