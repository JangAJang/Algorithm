import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        for(int index = 0; index < answer.length-1; index++){
            answer[index] = getIndexOfChar(s, index);
        }
        return answer;
    }

    private int getIndexOfChar(String s, int index){
        if(!s.contains(Character.toString(s.charAt(index)))) return -1;
        return s.substring(index+1).indexOf(s.charAt(index)) - index;
    }
}