import java.util.*;

class Solution {
    
    private int[][][] dp;
    
    private int[] dy = { -1, 1, 0, 0 };
    private int[] dx = { 0, 0, -1, 1 };
    
    public int solution(int[][] board) {
        int n = board.length;
        dp = new int[n][n][2];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                is2[0] = 4000;
                is2[1] = 4000;
            }
        }
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        bfs(board, n);
        return Math.min(dp[n-1][n-1][0], dp[n-1][n-1][1]) * 100;
    }
    
    private void bfs(final int[][] board, final int n) {
        Deque<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[] { 0, 0 });
        Integer[] qNow;
        int y, x, money0, money1;
        int ny, nx, ndir, nmoney;
        while (queue.size() > 0) {
            qNow = queue.poll();
            y = qNow[0];
            x = qNow[1];
            money0 = dp[y][x][0];
            money1 = dp[y][x][1];
            for (int i = 0; i < 4; i++) {
                ny = y + dy[i];
                nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny > n - 1 || nx > n - 1) continue;
                if (board[ny][nx] == 1) continue;
                ndir = i < 2 ? 1 : 0;
                nmoney = i < 2 ? 
                    Math.min(money0 + 6, money1 + 1) : Math.min(money0 + 1, money1 + 6);
                int next = dp[ny][nx][ndir];
                if (next > nmoney) {
                    dp[ny][nx][ndir] = nmoney;
                    queue.add(new Integer[] { ny, nx });
                }
            }
        }
    }
}