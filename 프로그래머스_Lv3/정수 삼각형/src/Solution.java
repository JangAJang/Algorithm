import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] result = new int[triangle.length][];
        result[0] = Arrays.copyOf(triangle[0], 1);
        for(int x = 0; x < triangle.length-1; x++){
            result[x+1] = Arrays.copyOf(triangle[x+1], triangle[x+1].length);
            for(int y = 0; y < triangle[x].length; y++){
                result[x+1][y] = Math.max(result[x][y] + triangle[x+1][y], result[x+1][y]);
                result[x+1][y+1] = Math.max(result[x][y] + triangle[x+1][y+1], result[x+1][y+1]);

            }
        }
        Arrays.sort(result[triangle.length-1]);
        return result[triangle.length-1][result[triangle.length-1].length-1];
    }
}