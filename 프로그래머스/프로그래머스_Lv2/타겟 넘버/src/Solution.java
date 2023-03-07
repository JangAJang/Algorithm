import java.util.Stack;

class Solution {
    private int answer = 0;
    private int[] value;

    public int solution(int[] numbers, int target) {
        value = numbers;
        getResultOfCalculation(0, 0, target);
        return answer;
    }

    private void getResultOfCalculation(int total, int index, int target){
        if(index == value.length){
            checkResult(total, target);
            return;
        }
        getResultOfCalculation(total + value[index], index+1, target);
        getResultOfCalculation(total - value[index], index+1, target);
    }

    private void checkResult(int total, int target){
        if(total == target) answer++;
    }
}