import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] map = new int[x][y];
        boolean[][] visited = new boolean[x][y];
        long[][] result = new long[x][y];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int xIndex = 0; xIndex< x; xIndex++ ) {
            st = new StringTokenizer(br.readLine());
            for(int yIndex = 0; yIndex < y; yIndex++ ) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 2) {
                    result[xIndex][yIndex] = 0;
                    queue.add(new int[]{xIndex, yIndex});
                    map[xIndex][yIndex] = 2;
                    continue;
                }
                result[xIndex][yIndex] = Long.MAX_VALUE;
                map[xIndex][yIndex] = value;
                continue;
            }
        }
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            
        }
    }
}