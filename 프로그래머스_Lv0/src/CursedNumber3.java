public class CursedNumber3 {
    // lv0. 저주의 숫자 3
    class Solution {
        public int solution(int n) {
            int notThreeNumber = 1;
            int counter = 1;
            while(counter < n){
                counter++;
                notThreeNumber = countNotThree(notThreeNumber);
            }
            return notThreeNumber;
        }

        private int countNotThree(int notThree){
            if((notThree+1)%3 == 0 || Integer.toString(notThree+1).contains("3")) return countNotThree(notThree+1);
            return notThree+1;
        }
    }
}
