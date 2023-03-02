import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] xMove = {1, -1, 0, 0};
    private static final int[] yMove = {0, 0, 1, -1};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        map = new char[count][count];
        for(int index = 0; index < count; index++){
            map[index] = br.readLine().toCharArray();
        }
        boolean[][][] visited = new boolean[2][count][count];
        int[] answer = new int[2];
        for(int cases = 0; cases < 2; cases++){
            for(int x = 0; x < count; x ++){
                for(int y = 0; y < count; y++){
                    if(!visited[cases][x][y]){
                        dfs(x, y, visited[cases], map[x][y]);
                        answer[cases]++;
                    }
                    if(map[x][y] == 'G') map[x][y] = 'R';
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void dfs(int x, int y, boolean[][] visited, char current){
        visited[x][y] = true;
        for(int index = 0; index < 4; index++){
            int nextX = x + xMove[index];
            int nextY = y + yMove[index];
            if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length || visited[nextX][nextY]
                    || map[nextX][nextY] != current)
                continue;
            dfs(nextX, nextY, visited, current);
        }
    }
}