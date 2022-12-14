public class SumOfEven {
    //lv0. 짝수의 합
    class Solution {
        public int solution(int n) {
            int result = 0;
            for(int index = 2; index <=n; index++){
                result += getResult(index);
            }
            return result;
        }

        private int getResult(int x){
            if(x%2 == 0) return x;
            return 0;
        }
    }
}
