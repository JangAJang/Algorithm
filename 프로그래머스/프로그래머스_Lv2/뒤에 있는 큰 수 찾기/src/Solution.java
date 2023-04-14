import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        for(int index = 0; index < numbers.length; index++){
            if(stack.isEmpty() || numbers[index] < numbers[index-1]){
                stack.push(index);
                continue;
            }
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[index]){
                answer[stack.pop()] = numbers[index];
            }
            stack.push(index);
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}