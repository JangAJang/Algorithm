public class Ants {
    //lv0. 개미 군단
    class Solution {

        private static final int GENERAL = 5;
        private static final int SOLDIER = 3;
        private static final int NORMAL = 1;

        private int count = 0;

        public int solution(int hp) {
            return countSoldiers(countGenerals(hp)) + count;
        }

        private int countGenerals(int hp){
            count += hp / GENERAL;
            return hp % GENERAL;
        }

        private int countSoldiers(int hp){
            count += hp / SOLDIER;
            return hp % SOLDIER;
        }
    }
}
