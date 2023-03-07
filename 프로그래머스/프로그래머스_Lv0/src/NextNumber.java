public class NextNumber {
    // lv0. 다음에 올 숫자
    class Solution {
        public int solution(int[] common) {
            if(common[0] != 0 && common[1] / common[0] * common[1] == common[2]){
                return common[1] / common[0] * common[common.length-1];
            }
            return common[1] - common[0] + common[common.length-1];
        }
    }
}
