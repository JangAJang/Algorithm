import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int N;
    static int M;
    static int[][] count;
    static boolean[][] visit;
    static Queue<Dot> ones;

    public static void main(String[] argsh)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        ones = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            String s = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j-1));
                if(arr[i][j] == 1) ones.add(new Dot(i, j));
            }
        }
        bfs();
    }

    static void bfs(){
        int[] x_area = {-1, 1, 0, 0};
        int[] y_area = {0, 0, -1, 1};
        while(!ones.isEmpty()){
            Dot delete = ones.poll();
            Queue<Dot> queue = new ArrayDeque<>();
            queue.add(new Dot(1, 1));
            visit[1][1] = true;
            count= new int[N+1][M+1];
            count[delete.getX()][delete.getY()] = -1;
            while(!queue.isEmpty()){
                Dot tmp = queue.poll();
                for(int i=0; i<4; i++){
                    int x = tmp.getX() + x_area[i];
                    int y = tmp.getY() + y_area[i];
                    if(x >=1 && y>=1 && x<=N && y<= M){
                        if(arr[x][y] == 0 && !visit[x][y]){
                            queue.add(new Dot(x, y));
                            visit[x][y] = true;
                            count[x][y] = count[tmp.getX()][tmp.getY()] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(count[N][M]);
    }
    static class Dot{
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
