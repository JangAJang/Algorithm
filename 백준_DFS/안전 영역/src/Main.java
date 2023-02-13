import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] visited;
    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];
        int maxHeight = 0;
        for(int x = 0; x < n; x++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int y = 0; y< n; y++){
                area[x][y] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(area[x][y], maxHeight);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int index = 0; index <= maxHeight; index++){
            visited = new boolean[area.length][area.length];
            result = Math.max(countAreas(area, index), result);
        }
        System.out.println(result);
    }

    private static int countAreas(int[][] area, int limit) {
        int count = 0;
        for(int x = 0; x < area.length; x++){
            for(int y = 0; y < area.length; y++) {
                if(area[x][y] > limit && !visited[x][y]) {
                    count+=dfs(area, new int[]{x, y}, limit);
                }
            }
        }
        return count;
    }

    private static int dfs(int[][] area, int[] current, int limit) {
        visited[current[0]][current[1]] = true;
        for(int index  = 0; index < 4; index ++){
            int[] next = new int[]{current[0] + xMove[index], current[1] + yMove[index]};
            if(next[0] >=0 && next[0] < area.length &&
                    next[1] >=0 && next[1] < area.length &&
                    !visited[next[0]][next[1]] &&
                    area[next[0]][next[1]] > limit){
                visited[next[0]][next[1]] = true;
                dfs(area, next, limit);
            }
        }
        return 1;
    }
}