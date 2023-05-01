public class AddSpecificInAP {

    class Solution {
        public int solution(int a, int d, boolean[] included) {
            int result = 0;
            int value = a;
            for (boolean b : included) {
                if (b) {
                    result += value;
                }
                value += d;
            }
            return result;
        }
    }
}
