import java.util.*;

class Solution {
    public int solution (int[] levels, int k) {
        Integer[] newArray = Arrays.stream(levels).boxed().toArray(Integer[]::new);
        Arrays.sort(newArray, Collections.reverseOrder());
        int answer = -1;
        return answer;
    }
}