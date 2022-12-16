public class CutPaper {
    // lv0. 종이 자르기
    class Solution {
        public int solution(int M, int N) {
            return Math.min(M, N)-1 + 2*(Math.max(M, N) -1);
         }
    }
}
