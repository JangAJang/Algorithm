import java.util.Arrays;

public class FindNumber {
    //lv0. 숫자 찾기
    class Solution {
        public int solution(int num, int k) {
            if(Integer.toString(num).contains(Integer.toString(k)))
                return Integer.toString(num).indexOf(Integer.toString(k))+1;
            return -1;
        }
    }
}
