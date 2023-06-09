import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static int[][] result;
    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[][] arr = new int[X][Y];
        result = new int[X][Y];
        int startX = 0;
        int startY = 0;
        for(int x = 0; x < X; x++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int y = 0; y < Y; y++){
                arr[x][y] = Integer.parseInt(st.nextToken());
                if(arr[x][y] == 2) {
                    startX = x;
                    startY = y;
                    result[x][y] = 0;
                }
            }
        }
        bfs(startX, startY, arr);
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < X; x++){
            for(int y = 0; y < Y; y++){
                if(result[x][y] == 0){
                    if(arr[x][y] == 0) {
                        result[x][y] = 0;
                    }
                    if(arr[x][y] == 1) {
                        result[x][y] = -1;
                    }
                }

                sb.append(result[x][y]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int startX, int startY, int[][] arr) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        queue.add(new int[]{startX, startY});
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[X_INDEX];
            int currentY = current[Y_INDEX];
            visited[currentX][currentY] = true;
            for(int index = 0; index < 4; index++) {
                int x = currentX + xMove[index];
                int y = currentY + yMove[index];
                if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) continue;
                if(arr[x][y] == 0) continue;
                if(visited[x][y]) continue;
                result[x][y] = result[currentX][currentY] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }
}