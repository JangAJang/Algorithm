import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//문제 : 반례를 통과하지 못함. 벽이 있는 곳을 한군데만 0으로 바꿔서 해볼까?
public class Main {

    public static class Position{
        int x;
        int y;
        boolean wall_broken;

        public Position(int x, int y, boolean wall_broken){
            this.x = x;
            this.y = y;
            this.wall_broken = wall_broken;
        }
    }

    static int[] x_pos = {-1, 0, 1, 0};
    static int[] y_pos = {0, -1, 0, 1};
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] radix;
    static long[][] result;
    static Queue<Position> queue;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        radix = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        result = new long[N+1][M+1];
        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                radix[i][j] = Character.getNumericValue(s.charAt(j-1));
                result[i][j] = Long.MAX_VALUE;
            }
        }
        bfs();
    }

    public static void bfs(){
        queue = new LinkedList<>();
        queue.add(new Position(1, 1, false));
        visited[1][1] = true;
        result[1][1] = 1;
        while(!queue.isEmpty()){
            Position now = queue.poll();
            System.out.println(now.x + " " + now.y + " " + result[now.x][now.y]);
            for(int i=0; i<4; i++){
                int next_x = x_pos[i] + now.x;
                int next_y = y_pos[i] + now.y;
                if(next_x ==0 || next_y == 0 || next_x > N || next_y > M) continue;
                if(visited[next_x][next_y]) continue;
                if(now.wall_broken) {
                    if(radix[next_x][next_y] == 0){
                        queue.add(new Position(next_x, next_y, true));
                        visited[next_x][next_y] = true;
                        result[next_x][next_y] = Math.min(result[next_x][next_y], result[now.x][now.y] + 1);
                    }
                }
                else {
                    if(radix[next_x][next_y] == 0){
                        queue.add(new Position(next_x, next_y, false));
                    }
                    else{
                        queue.add(new Position(next_x, next_y, true));
                    }
                    result[next_x][next_y] = Math.min(result[next_x][next_y], result[now.x][now.y] + 1);
                    visited[next_x][next_y] = true;
                }
            }
        }
        if(visited[N][M]) System.out.println(result[N][M]);
        else System.out.println("-1");
    }
}
