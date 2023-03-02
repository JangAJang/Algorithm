import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] x_case = {-1, 0, 1, 0};
    static int[] y_case = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int x;
    static int y;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr = new int[x+1][y+1];
        visited = new boolean[x+1][y+1];
        for(int i=1; i<=x; i++){
            String s = br.readLine();
            for(int j=1; j<=y; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j-1));
            }
        }
        visited[1][1] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int i=0; i<4; i++){
                int a = point[0] + x_case[i];
                int b = point[1] + y_case[i];
                if(a < 1 || b < 1 || a > x || b > y) continue;
                if(visited[a][b] || arr[a][b] == 0)continue;
                queue.add(new int[]{a, b});
                arr[a][b] = arr[point[0]][point[1]] + 1;
                visited[a][b] = true;
            }
        }
        System.out.println(arr[x][y]);
    }
}
