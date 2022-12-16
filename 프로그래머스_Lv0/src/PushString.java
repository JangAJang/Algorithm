public class PushString {
    // lv0. 문자열 밀기
    class Solution {
        public int solution(String A, String B) {
            return (B + B).indexOf(A);
        }
    }
}
