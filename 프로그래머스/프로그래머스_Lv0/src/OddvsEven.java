public class OddvsEven {
    //홀수 vs 짝수
    class Solution {
        public int solution(int[] num_list) {
            int index = 1;
            int odd = 0;
            int even = 0;
            int last = num_list.length;
            while(index < last) {
                even += num_list[index];
                odd += num_list[index-1];
                index +=2;
            }
            if(last % 2 != 0) {
                odd += num_list[last-1];
            }
            return Math.max(odd, even);
        }
    }
}
