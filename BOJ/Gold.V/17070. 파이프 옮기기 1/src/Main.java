import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int ans;

    private static final int ROW = 0;
    private static final int COL = 1;
    private static final int CROSS = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        DFS(1, 2, 0);
        System.out.println(ans);
    }

    public static void DFS(int x, int y, int direction) {
        if (x == N && y == N) {
            ans++;
            return;
        }
        moveDirection(x, y, direction);
        if (y + 1 <= N && x + 1 <= N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            DFS(x + 1, y + 1, CROSS);
        }
    }

    private static void moveDirection(int x, int y, int direction){
        if(direction == ROW && (y + 1 <= N && map[x][y + 1] == 0)){
            DFS(x, y + 1, ROW);
            return;
        }
        if(direction == COL && (x + 1 <= N && map[x + 1][y] == 0)){
            DFS(x + 1, y, COL);
            return;
        }
        if(direction == CROSS) {
            if (y + 1 <= N && map[x][y + 1] == 0) {
                DFS(x, y + 1, ROW);
            }
            if (x + 1 <= N && map[x + 1][y] == 0) {
                DFS(x + 1, y, COL);
            }
        }
    }

}
