public class CutPaper {
    // lv0. 종이 자르기
    class Solution {
        public int solution(int M, int N) {
            return Math.min((M-1) + M*(N-1), (N-1) + N*(M-1));
         }
    }
}
