import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a1, a2)-> (a1[1]-a2[1]));
        int end = targets[0][1];
        int count = 0;
        for(int[] target : targets){
            if(end <= target[0]){
                end = target[1];
                count++;
            }
        }
        return count+1;
    }
}