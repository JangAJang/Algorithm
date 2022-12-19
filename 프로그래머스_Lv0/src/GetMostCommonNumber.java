import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetMostCommonNumber {
    // lv0. 최빈값 구하기
    class Solution {
        public int solution(int[] array) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(array[0]);
            int maxCount = (int)Arrays.stream(array).filter(s-> s == array[0]).count();
            for(int index = 1; index < array.length; index++){
                int value = array[index];
                if(value == numbers.get(0)) continue;
                int countIndex = (int)Arrays.stream(array).filter(s -> s == value).count();
                if(countIndex > maxCount){
                    System.out.println(value + " " + countIndex);
                    numbers.clear();
                    numbers.add(value);
                    maxCount = countIndex;
                    continue;
                }
                if(countIndex == maxCount){
                    numbers.add(value);
                }
            }
            if(numbers.size() > 1) return -1;
            return numbers.get(0);
        }
    }
}
