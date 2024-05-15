package DailyQuestions;

public class FindTheSafetestPathInGrid {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] arr = new int[grid.size()][grid.size()];
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr.length; y++) {
                arr[x][y] = grid.get(x).get(y);
            }
        }
        return solveByArray(arr);
    }

    public int solveByArray(int[][] grid) {
        int n = grid.length;
        int[][] distance = new int[n][n];
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                distance[x][y] = Integer.MAX_VALUE;
            }
        }

        // Step 1: BFS to calculate the minimum distance to any thief
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        int[] directions = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + directions[k], nc = c + directions[k + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distance[nr][nc] == Integer.MAX_VALUE) {
                    distance[nr][nc] = distance[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Binary search for the maximum safeness factor
        int left = 0, right = n * 2;  // Safe factors range from 0 to n*2
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canReachEndWithSafeness(grid, distance, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canReachEndWithSafeness(int[][] grid, int[][] distance, int safenessFactor) {
        int n = grid.length;
        if (distance[0][0] < safenessFactor) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[] directions = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            if (r == n - 1 && c == n - 1) return true;
            for (int k = 0; k < 4; k++) {
                int nr = r + directions[k], nc = c + directions[k + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && distance[nr][nc] >= safenessFactor) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
}
