import java.util.*;
import java.util.stream.*;

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] field = new int[m+1][n+1];
        field[1][1] = 1;
        for(int[] puddle : puddles){
            field[puddle[0]][puddle[1]] = -1;
        }
        for(int index = 2; index <=m; index++){
            if(field[index][1] == -1 || field[index-1][1] == -1) {
                field[index][1] = -1;
                continue;
            }
            field[index][1] = 1;
        }
        for(int index = 2; index <=n; index++){
            if(field[1][index] == -1 || field[1][index-1] == -1) {
                field[1][index] = -1;
                continue;
            }
            field[1][index] = 1;
        }
        for(int x = 2; x <=m; x++){
            for(int y = 2; y <=n; y++){
                if(field[x][y] == -1) continue;
                int[] result = new int[2];
                result[0] = field[x-1][y];
                result[1] = field[x][y-1];
                if(result[0] == -1 && result[1] == -1){
                    field[x][y] = -1;
                    continue;
                }
                if((result[0] != -1 && result[1] == -1) || (result[0] == -1 && result[1] != -1)){
                    field[x][y] = Math.max(result[0], result[1]) % 1000000007;
                    continue;
                }
                field[x][y] = (result[0] + result[1]) % 1000000007;
            }
        }
        if(field[m][n] == -1) field[m][n] = 0;
        return field[m][n];
    }
}