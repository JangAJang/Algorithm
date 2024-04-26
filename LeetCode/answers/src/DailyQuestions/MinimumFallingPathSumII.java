package DailyQuestions;

public class MinimumFallingPathSumII {

    private static final int[] yMove = new int[]{-1, 1};

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                dp[x][y] = Integer.MAX_VALUE;
            }
        }

        for(int index = 0; index < grid[0].length; index++) {
            dp[0][index] = grid[0][index];
        }

        for(int x = 1; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                for(int index = 0; index < 2; index++) {
                    int nextY = y + yMove[index];
                    if(nextY < 0 || nextY >= grid[0].length) continue;
                    dp[x][nextY] = Math.min(dp[x][nextY], dp[x-1][y] + grid[x][nextY]);
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for(int y = 0; y < grid[0].length; y++) {
            max = Math.min(dp[dp.length-1][y], max);
        }

        return max;
    }
}
