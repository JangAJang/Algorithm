public class NthElement {
    class Solution {
        public int[] solution(int[] num_list, int n) {
            int[] answer = new int[n];
            for(int index = 0; index < n; index++){
                answer[index] = num_list[index];
            }
            return answer;
        }
    }
}
