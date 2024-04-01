import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Gold2. 16946. 벽 부수고 이동하기 4
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] visited;
    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};
    private static int[][][] parent;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        char[][] arr = new char[X][Y];
        visited = new boolean[X][Y];
        result = new int[X][Y];
        parent = new int[X][Y][2];
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < X; x++) {
            arr[x] = br.readLine().toCharArray();
            for(int y = 0; y < Y; y++) {
                parent[x][y][0] = x;
                parent[x][y][1] = y;
            }
        }

        for(int x = 0; x < X; x++) {
            for(int y = 0; y < Y; y++) {
                if(arr[x][y] == '0') {
                    result[x][y] = bfs(arr, x, y);
                }
            }
        }

        for(int x = 0; x < X; x++) {
            for(int y = 0; y < Y; y++) {
                if(arr[x][y] == '0') {
                    sb.append(0);
                    continue;
                }
                int count = 0;
                for(int index = 0; index < 4; index++) {
                    int nextX = xMove[index] + x;
                    int nextY = yMove[index] + y;
                    if(nextX < 0 || nextX >= arr.length) continue;
                    if(nextY < 0 || nextY >= arr[0].length) continue;
                    count += findParentCount(nextX, nextY);
                }
                sb.append((count+1)%10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(final char[][] arr, final int a, final int b) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{a, b});
        int count = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            count++;
            for(int index = 0; index < 4; index++) {
                int x = xMove[index] + current[0];
                int y = yMove[index] + current[1];
                if(x < 0 || x >= arr.length) continue;
                if(y < 0 || y >= arr[0].length) continue;
                if(visited[x][y]) continue;
                if(arr[x][y] == '1') continue;
                int[] next = new int[]{x, y};
                union(current, next);
                queue.add(next);
            }
        }
        return count;
    }

    private static int findParentCount(final int x, final int y) {
        int[] p = find(x, y);
        return result[p[0]][p[1]];
    }

    private static int[] find(int x, int y) {
        int[] myParent = parent[x][y];
        if(myParent[0] == x && myParent[1] == y) return new int[]{x, y};
        return parent[x][y] = find(myParent[0], myParent[1]);
    }

    private static void union(final int[] current, final int[] next) {
        int[] currentParent = find(current[0], current[1]);
        int[] nextParent = find(next[0], next[1]);
        if(currentParent[0] == nextParent[0] && currentParent[1] == nextParent[1]) return;
        parent[next[0]][next[1]] = currentParent;
    }
}