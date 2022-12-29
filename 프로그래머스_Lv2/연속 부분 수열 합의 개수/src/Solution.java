import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> number = new HashSet<>();

    public int solution(int[] elements) {
        int[] numbers = makeDouble(elements);
        for(int index = 1; index <= elements.length; index++){
            countNumbersAvailable(numbers, index);
        }
        return number.size();
    }

    private int[] makeDouble(int[] elements){
        int[] doubled = new int[elements.length*2];
        for(int index = 0; index < elements.length; index++){
            doubled[index]= elements[index];
            doubled[index+elements.length]= elements[index];
        }
        return doubled;
    }

    private void countNumbersAvailable(int[] numbers, int index){
        for(int start = 0; start < numbers.length - index + 1; start++){
            int result = 0;
            for(int numbersStart = start; numbersStart < index+start; numbersStart++){
                result += numbers[numbersStart];
            }
            number.add(result);
        }
    }
}