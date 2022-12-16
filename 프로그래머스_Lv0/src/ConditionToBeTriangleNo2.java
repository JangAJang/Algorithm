public class ConditionToBeTriangleNo2 {
    // lv0. 삼각형의 완성조건(2)
    class Solution {
        public int solution(int[] sides) {
            return sides[0]+sides[1] - Math.abs(sides[0]-sides[1]) -1;
        }
    }
}
