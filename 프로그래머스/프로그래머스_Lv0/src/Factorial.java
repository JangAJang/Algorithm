public class Factorial {
    // lv0. 팩토리얼
    class Solution {
        public int solution(int n) {
            int result = 1;
            int count = 0;
            do{
                count++;
                result *= count;
            }while(result <= n);
            return count-1;
        }
    }
}
