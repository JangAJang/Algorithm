public class CountEvenAndOdd {
    //lv0. 짝수 홀수 개수
    class Solution {

        private int even = 0;
        private int odd = 0;

        public int[] solution(int[] num_list) {
            countEvenAndOdd(num_list);
            return new int[]{even, odd};
        }

        private boolean isEven(int x){
            return x % 2 == 0;
        }

        private void checkNumber(int numberEach){
            if(isEven(numberEach)) {
                even++;
                return;
            }
            odd++;
        }

        private void countEvenAndOdd(int[] num_list){
            for(int numberEach : num_list){
                checkNumber(numberEach);
            }
        }
    }
}
