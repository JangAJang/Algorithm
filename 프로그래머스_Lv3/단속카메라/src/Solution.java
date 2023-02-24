import java.util.*;

class Solution {

    private int location = -3_0001;
    private int count = 0;

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        for(int[] route : routes){
            if(route[0] <= location) continue;
            location = route[1];
            count++;
        }
        return count;
    }
}