import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr;
    static boolean[][][] visited;
    static int count = 0;
    static int day = 0;
    static int m;
    static int n;
    static int o;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());
        arr = new int[n][m][o];
        visited = new boolean[n][m][o];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int k=0; k<o; k++){
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<m; j++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) queue.add(new int[]{i, j, k});
                    else if(arr[i][j][k] == 0) count++;
                }
            }
        }
        while(count > 0 && !queue.isEmpty()){
            for(int i = queue.size(); i > 0; i--){
                int[] one = queue.poll();
                int[] x_area = {-1, 1, 0, 0, 0, 0};
                int[] y_area = {0, 0, -1, 1, 0, 0};
                int[] z_area = {0, 0, 0, 0, -1, 1};
                for(int k=0; k<6; k++){
                    int x = x_area[k] + one[0];
                    int y = y_area[k] + one[1];
                    int z = z_area[k] + one[2];
                    if(x<0 || y<0 || z<0|| x >= n || y >= m || z>=o|| arr[x][y][z] != 0) continue;
                    count--;
                    arr[x][y][z] = 1;
                    queue.add(new int[]{x, y, z});
                }
            }
            day++;
        }
        if(count == 0){
            System.out.println(day);
        }
        else System.out.println(-1);
    }
}
