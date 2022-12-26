import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    int solution(int[][] land) {
        for(int index = 1; index < land.length; index++){
            land[index][0] += Math.max(Math.max(land[index-1][1], land[index-1][2]), land[index-1][3]);
            land[index][1] += Math.max(Math.max(land[index-1][0], land[index-1][2]), land[index-1][3]);
            land[index][2] += Math.max(Math.max(land[index-1][0], land[index-1][1]), land[index-1][3]);
            land[index][3] += Math.max(Math.max(land[index-1][0], land[index-1][1]), land[index-1][2]);
        }
        return Arrays.stream(land[land.length-1]).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);
    }
}