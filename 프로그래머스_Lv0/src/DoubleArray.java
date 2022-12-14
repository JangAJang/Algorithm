public class DoubleArray {
    //lv0. 배열 두배 만들기
    class Solution {

        public int[] solution(int[] numbers) {
            return doubleEachNumber(numbers);
        }

        private int[] doubleEachNumber(int[] numbers) {
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] *= 2;
            }
            return numbers;
        }
    }
}
