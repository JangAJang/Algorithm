package DailyQuestions;

public class PathWithMaximumGold {

    int maxGold = 0;
    int[] xMove = {1, -1, 0, 0};
    int[] yMove = {0, 0, -1, 1};

    public int checkIfAllZeros(int[][] grid) {
        int count = 0;
        for (int X = 0; X < grid.length; X++) {
            for (int Y = 0; Y < grid[0].length; Y++) {
                if (grid[X][Y] != 0) count += grid[X][Y];
                else return 0;
            }
        }
        return count;
    }

    public void backtrack(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;

        if (grid[x][y] != 0) {
            int curr = grid[x][y];
            grid[x][y] = 0;
            count += curr;
            maxGold = Math.max(maxGold, count);

            for (int i = 0; i < 4; i++) {
                int newX = x + xMove[i];
                int newY = y + yMove[i];
                backtrack(grid, newX, newY, count);
            }

            grid[x][y] = curr;
        }
    }

    public int getMaximumGold(int[][] grid) {
        int count = checkIfAllZeros(grid);
        if (count != 0) return count;

        for (int X = 0; X < grid.length; X++) {
            for (int Y = 0; Y < grid[0].length; Y++) {
                if (grid[X][Y] != 0) {
                    backtrack(grid, X, Y, 0);
                }
            }
        }

        return maxGold;
    }
}
