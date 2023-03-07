import java.util.Arrays;

public class TallerThanMe {
    //lv0. 머쓱이보다 키 큰 사람
    class Solution {
        public int solution(int[] array, int height) {
            return (int)countTallerThanMe(array, height);
        }

        private long countTallerThanMe(int[] allHeight, int myHeight){
            return Arrays.stream(allHeight).filter(s-> s > myHeight).count();
        }
    }
}
