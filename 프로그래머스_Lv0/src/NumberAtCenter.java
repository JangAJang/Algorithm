import java.util.Arrays;

public class NumberAtCenter {
    //lv0. 중앙값 구하기
    class Solution {
        public int solution(int[] array) {
            Arrays.sort(array);
            return getCenterOfArray(array);
        }

        private int getCenterOfArray(int[] array){
            return array[array.length/2];
        }
    }
}
