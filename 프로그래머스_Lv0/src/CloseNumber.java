public class CloseNumber {
    // lv0. 가까운 수
    class Solution {
        public int solution(int[] array, int n) {
            int answer = 0;
            for(int each : array){
                answer = getAnswer(each, answer, n);
            }
            return answer;
        }

        private int getAnswer(int each, int answer, int n){
            if(Math.abs(each - n) == Math.abs(answer - n)) {
                return Math.min(each, answer);

            }
            return Math.abs(each - n) <= Math.abs(answer - n) ? each : answer;
        }
    }
}
