public class MakeSquare {
    // lv0. 직사각형 넓이 구하기
    class Solution {
        public int solution(int[][] dots) {
            int x = 0;
            int y = 0;
            for(int index = 1; index < dots.length; index++){
                x = Math.max(x, Math.abs(dots[0][0] - dots[index][0]));
                y = Math.max(y, Math.abs(dots[0][1] - dots[index][1]));
            }
            return x * y;
        }
    }
}
