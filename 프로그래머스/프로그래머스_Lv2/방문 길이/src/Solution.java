class Solution {

    private boolean[][] visited;
    public int solution(String dirs) {
        visited = new boolean[11][11];
        int[] start = new int[]{5, 5};
        return getMovingDistance(start, dirs, 0);
    }

    private int getMovingDistance(int[] start, String dirs, int count) {
        if(dirs.equals("")) return count;
        int[] next = move(start, dirs.charAt(0));
        if ((visited[next[0]][next[1]] && visited[start[0]][start[1]])
                || (next[0] == start[0] && next[1] == start[1])) {
            return getMovingDistance(next, dirs.substring(1), count);
        }
        visited[start[0]][start[1]] = true;
        return getMovingDistance(next, dirs.substring(1), count+1);
    }

    private int[] move(int[] loc, char command) {
        if( command == 'U') {
            return new int[]{loc[0], Math.min(10, loc[1]+1)};
        }
        if( command == 'D') {
            return new int[]{loc[0], Math.max(0, loc[1]-1)};
        }
        if( command == 'L') {
            return new int[]{Math.max(0, loc[0]-1), loc[1]};
        }
        return new int[]{Math.min(10, loc[0]+1), loc[1]};
    }
}