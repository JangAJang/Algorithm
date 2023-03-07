
class SolutionByDFS {

    private boolean[][] visited;
    private int max = Integer.MIN_VALUE;

    int solution(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        dfs(land, 0);
        return max;
    }

    private void dfs(int[][] land, int index){
        if(index == land.length) {
            changeMax(land);
            return;
        }
        for(int cases = 0; cases < 4; cases++){
            if(isNotInSameLine(index, cases)) visited[index][cases] = true;
            dfs(land, index+1);
            visited[index][cases] = false;
        }
    }

    private boolean isNotInSameLine(int index, int cases){
        for(int check = 0; check < index; check++){
            if(visited[check][cases]) return false;
        }
        return true;
    }

    private void changeMax(int[][] land){
        int total = 0;
        for(int x = 0; x < land.length; x++){
            for(int y = 0; y < land[x].length; y++){
                if(visited[x][y]) total += land[x][y];
            }
        }
        max= Math.max(max, total);
    }
}