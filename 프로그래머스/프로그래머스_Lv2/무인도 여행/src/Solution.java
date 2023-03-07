import java.util.*;
import java.util.stream.*;

class Solution {

    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};

    private int[][] map;
    private boolean[][] visited;

    public List<Integer> solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int x = 0; x < map.length; x++){
            String[] each = maps[x].split("");
            for(int y = 0; y < each.length; y++){
                if(each[y].equals("X")){
                    map[x][y] = 0;
                    continue;
                }
                map[x][y] = Integer.parseInt(each[y]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[0].length; y++){
                if(visited[x][y] || map[x][y] == 0) continue;
                result.add(calculateDFS(new int[]{x, y}));
            }
        }
        Collections.sort(result);
        if(result.isEmpty()) result.add(-1);
        return result;
    }

    private int calculateDFS(int[] loc){
        int total = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(loc);
        visited[loc[0]][loc[1]] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            total += map[x][y];
            for(int index = 0; index < 4; index++){
                int nextX = x + xMove[index];
                int nextY = y + yMove[index];
                if(nextX < 0 || nextX >= map.length || nextY < 0
                        || nextY >= map[0].length) continue;
                if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY});
            }
        }
        return total;
    }
}