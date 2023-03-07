public class Angle {
    // lv0. 각도기
    class Solution {
        public int solution(int angle) {
            if((angle+360)%360 < 90) return 1;
            if((angle+360)%360 == 90) return 2;
            if((angle+360)%360 == 180) return 4;
            return 3;
        }
    }
}
