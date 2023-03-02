import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int k;
    static int width;
    static int height;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- >0){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[width][height];
            visited = new boolean[width][height];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine(), " ");
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
            }
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    if(!visited[i][j] && arr[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                    else if(arr[i][j] == 0) visited[i][j] = true;
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        int[] x_range = {-1, 1, 0, 0};
        int[] y_range = {0, 0, -1, 1};
        for(int i=0; i<4; i++){
            int final_x = x + x_range[i];
            int final_y = y + y_range[i];
            if(final_x >=0 && final_y >=0 && final_x < width && final_y < height){
                if(!visited[final_x][final_y] && arr[final_x][final_y] == 1){
                    dfs(final_x, final_y);
                }
            }
        }
    }
}
