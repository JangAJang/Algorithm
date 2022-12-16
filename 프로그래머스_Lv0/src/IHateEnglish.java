public class IHateEnglish {
    // lv0. 영어가 싫어요
    class Solution {

        private final String[] NUMBERS = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        public long solution(String numbers) {
            for(int index = 0; index < 10; index++){
                numbers = numbers.replace(NUMBERS[index], Integer.toString(index));
            }
            return Long.parseLong(numbers);
        }
    }
}
