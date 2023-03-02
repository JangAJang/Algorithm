import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Location{
        int x;
        int y;

        boolean wall_broken;
        int count;

        public Location(int x, int y, int count, boolean wall_broken){
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall_broken = wall_broken;
        }
    }

    static int N;
    static int M;
    static int[] x_case = {-1, 0, 1, 0};
    static int[] y_case = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][][] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2];
        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }
        bfs();
    }

    public static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1, 1, 1, false));
        visited[1][1][0] = true;
        while(!queue.isEmpty()){
            Location now = queue.poll();
            if(now.x == N && now.y == M) {
                System.out.println(now.count);
                return;
            }
            for(int i=0; i<4; i++){
                int newX = x_case[i] + now.x;
                int newY = y_case[i] + now.y;
                if(newX == 0 || newY == 0 || newX > N || newY > M)continue;
                int newCount = now.count+1;
                if(arr[newX][newY] == 0){
                    if(!now.wall_broken && !visited[newX][newY][0]){
                        queue.add(new Location(newX, newY, newCount, false));
                        visited[newX][newY][0] = true;
                    }
                    else if(now.wall_broken && !visited[newX][newY][1]){
                        queue.add(new Location(newX, newY, newCount, true));
                        visited[newX][newY][1] = true;
                    }
                }
                else if(arr[newX][newY] == 1 && !visited[newX][newY][1]){
                    if(!now.wall_broken){
                        queue.add(new Location(newX, newY, newCount, true));
                        visited[newX][newY][1] = true;
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
