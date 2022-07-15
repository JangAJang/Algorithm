import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int length= Integer.MAX_VALUE;
    static int n;
    static int m;
    static int count = 1;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=m; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }
        dfs(1, 1);
        System.out.println(length);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        if(x == n && y == m) {
            length = Math.min(length, count);
            return;
        }
        else{
            int[] x_range = {-1, 1, 0, 0};
            int[] y_range = {0, 0, -1, 1};
            for(int i=0; i<4; i++){
                int fx = x + x_range[i];
                int fy = y + y_range[i];
                if(fx >=1 && fy >=1 && fx <=n && fy <=m){
                    if(arr[fx][fy] == 1 && !visited[fx][fy]){
                        count++;
                        dfs(fx, fy);
                    }
                }
            }
        }
        visited[x][y] = false;
        count--;
    }
}
