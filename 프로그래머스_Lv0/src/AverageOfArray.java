import java.util.Arrays;

public class AverageOfArray {
    //lv0. 배열의 평균값
    class Solution {
        public double solution(int[] numbers) {
            return getSum(numbers) / numbers.length;
        }

        private double getSum(int[] numbers){
            double result = 0;
            for(int numberEach : numbers){
                result += numberEach;
            }
            return result;
        }
    }
}
