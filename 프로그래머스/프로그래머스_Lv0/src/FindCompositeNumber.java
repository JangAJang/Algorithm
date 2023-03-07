public class FindCompositeNumber {
    // lv0. 합성수 찾기
    class Solution {
        public int solution(int n) {
            int count = 0;
            for(int number = 1; number <= n;  number++){
                if(!isPrime(number)) {
                    System.out.println(number);
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int number){
            int count = 0;
            for(int index = 1; index <= Math.sqrt(number); index++){
                if(number % index == 0) count++;
            }
            return count == 1;
        }
    }
}
