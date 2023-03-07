import java.util.Arrays;

public class ArrayElementLength {
    //lv0. 배열 원소 길이
    class Solution {
        public int[] solution(String[] strlist) {
            return countEachLength(strlist);
        }

        private int[] countEachLength(String[] strlist){
            return Arrays.stream(strlist).mapToInt(String::length).toArray();
        }
    }
}
