import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    // lv0. 배열 회전시키기
    class Solution {
        public int[] solution(int[] numbers, String direction) {
            if(direction.equals("left")) return moveLeft(numbers);
            return moveRight(numbers);
        }

        private int[] moveLeft(int[] numbers){
            List<Integer> newNumbers = new ArrayList<>();
            for(int index = 1; index < numbers.length; index++){
                newNumbers.add(numbers[index]);
            }
            newNumbers.add(numbers[0]);
            return newNumbers.stream().mapToInt(Integer::intValue).toArray();
        }

        private int[] moveRight(int[] numbers){
            List<Integer> newNumbers = new ArrayList<>();
            newNumbers.add(numbers[numbers.length-1]);
            for(int index = 0; index < numbers.length-1; index++){
                newNumbers.add(numbers[index]);
            }
            return newNumbers.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
