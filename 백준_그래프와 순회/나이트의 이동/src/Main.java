import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int moveX[] = {1,2,2,1,-1,-2,-2,-1};
    static int moveY[] = {-2,-1,1,2,2,1,-1,-2};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine(), " ");
            int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            bfs(start, end, arr);
        }
    }

    static void bfs(int[] start, int[] end, int[][] arr){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        boolean[][] visit = new boolean[arr.length][arr.length];
        visit[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == end[0] && tmp[1] == end[1]){
                System.out.println(arr[tmp[0]][tmp[1]]);
                return;
            }
            for(int d=0; d<8; d++){
                int x = tmp[0] + moveX[d];
                int y = tmp[1] + moveY[d];
                if(0<= x && x<arr.length && 0<=y && y<arr.length ){
                    if(!visit[x][y]){
                        visit[x][y] = true;
                        arr[x][y] = arr[tmp[0]][tmp[1]]+1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}