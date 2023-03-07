public class DeleteSpecificLetter {
    //lv0. 특정 문자 제거하기
    class Solution {
        public String solution(String my_string, String letter) {
            return my_string.replaceAll(letter, "");
        }
    }
}
