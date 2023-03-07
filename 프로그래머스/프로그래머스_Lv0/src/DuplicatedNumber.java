import java.util.Arrays;

public class DuplicatedNumber {
    //lv0. 중복된 숫자 개수
    class Solution {
        public int solution(int[] array, int n) {
            return (int)countDuplicatedNCount(array, n);
        }

        private long countDuplicatedNCount(int[] array, int n){
            return Arrays.stream(array).filter(s-> s == n).count();
        }
    }
}
