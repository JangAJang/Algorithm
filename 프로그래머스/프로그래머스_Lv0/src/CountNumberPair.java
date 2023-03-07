public class CountNumberPair {
    //lv0. 순서쌍의 개수
    class Solution {
        public int solution(int n) {
            if(isPowered(n)) return countDivider(n)*2 -1;
            return countDivider(n)*2;
        }

        private boolean isPowered(int n){
            return n % Math.sqrt(n) == 0;
        }

        private int countDivider(int n){
            int count = 0;
            for(int number = 1; number <= Math.sqrt(n); number++){
                count += checkDivision(n, number);
            }
            return count;
        }

        private int checkDivision(int n, int number){
            if(n%number == 0) return 1;
            return 0;
        }
    }
}
