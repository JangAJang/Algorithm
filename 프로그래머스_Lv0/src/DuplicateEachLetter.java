import java.util.Arrays;

public class DuplicateEachLetter {
    //lv0. 문자 반복 출력하기
    class Solution {
        public String solution(String my_string, int n) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(my_string.split("")).forEach(s-> stringBuilder.append(duplicateLetter(s, n)));
            return stringBuilder.toString();
        }

        private String duplicateLetter(String letter, int n){
            StringBuilder stringBuilder = new StringBuilder();
            while(n-- > 0) stringBuilder.append(letter);
            return stringBuilder.toString();
        }
    }
}
