import java.util.Arrays;

public class ConditionToBeTriangle {
    //lv0. 삼각형이 되기 위한 완성조건
    class Solution {
        public int solution(int[] sides) {
            Arrays.sort(sides);
            if(isTriangle(sides)) return 1;
            return 2;
        }

        private boolean isTriangle(int[] sides){
            return (sides[2] < sides[1] + sides[0]);
        }
    }
}
