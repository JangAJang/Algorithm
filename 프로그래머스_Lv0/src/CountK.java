import java.util.Arrays;

public class CountK {
    // lv0. k의 개수
    class Solution {
        public int solution(int i, int j, int k) {
            int count = 0;
            for(int number = i; number <=j; number++){
                count += Arrays.stream(Integer.toString(number).split("")).filter(s-> s.equals(Integer.toString(k))).count();
            }
            return count;
        }
    }
}
