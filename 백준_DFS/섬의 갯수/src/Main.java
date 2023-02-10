import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final int[] xMove = {0, 0, 1, 1, 1, -1, -1, -1};
    private static final int[] yMove = {1, -1, 0, 1, -1, 0, 1, -1};
    private static boolean[][] visited;


    public static void main(String[] args) {
        while(true){
            int y = sc.nextInt();
            int x = sc.nextInt();
            if(x == 0 && y == 0) return;
            System.out.println(countIsland(x, y));
        }
    }

    private static int countIsland(int x, int y){
        int[][] field = new int[x][y];
        visited = new boolean[x][y];
        for(int xIndex = 0; xIndex < x; xIndex++){
            for(int yIndex = 0; yIndex < y; yIndex++){
                field[xIndex][yIndex] = sc.nextInt();
            }
        }
        int count = 0;
        for(int xIndex = 0; xIndex < x; xIndex++){
            for(int yIndex = 0; yIndex < y; yIndex++){
                if(!visited[xIndex][yIndex] && field[xIndex][yIndex] == 1){
                    dfs(new int[]{xIndex, yIndex}, field);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[] start, int[][] field){
        Stack<int[]> grounds = new Stack<>();
        grounds.push(start);
        while(!grounds.isEmpty()){
            int[] current = grounds.pop();
            for(int index = 0; index < 8; index++){
                int nextX = current[0] + xMove[index];
                int nextY = current[1] + yMove[index];
                if(nextX >=0 && nextY >=0 && nextX < Math.min(50, field.length) && nextY < Math.min(50, field[0].length)
                        && !visited[nextX][nextY] && field[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    grounds.push(new int[]{nextX, nextY});
                }
            }
        }
    }
}