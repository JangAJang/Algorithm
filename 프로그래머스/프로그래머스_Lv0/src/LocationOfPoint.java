public class LocationOfPoint {
    //lv0. 점의 위치 구하기
    class Solution {

        private static final int X_INDEX = 0;
        private static final int Y_INDEX = 1;

        public int solution(int[] dot) {
            if(isXPositive(dot[X_INDEX]) && isYPositive(dot[Y_INDEX])) return 1;
            if(!isXPositive(dot[X_INDEX]) && isYPositive(dot[Y_INDEX])) return 2;
            if(!isXPositive(dot[X_INDEX]) && !isYPositive(dot[Y_INDEX])) return 3;
            return 4;
        }

        private boolean isXPositive(int x){
            return x > 0;
        }

        private boolean isYPositive(int y){
            return y > 0;
        }
    }
}
