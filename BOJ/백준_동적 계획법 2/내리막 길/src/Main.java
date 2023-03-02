import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int width;
    static int height;
    static int[][] arr;
    static int[][] result;
    static int[] rangeW = {-1, 0, 1, 0};
    static int[] rangeH = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        arr = new int[width+1][height+1];
        result = new int[width+1][height+1];
        for(int i=1; i<=width; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=height; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
            }
        }
        bw.write(dfs(1, 1) + "\n");
        bw.flush();
    }

    static int dfs(int x, int y){
        if(x==width && y == height) return 1;
        if(result[x][y] != -1) return result[x][y];
        result[x][y] = 0;
        for(int i=0; i<4; i++){
            int newW = x + rangeW[i];
            int newH = y + rangeH[i];
            if(newW <1 || newH <1 || newW > width || newH > height) continue;
            if(arr[x][y] > arr[newW][newH]) result[x][y] += dfs(newW, newH);
        }
        return result[x][y];
    }
}

