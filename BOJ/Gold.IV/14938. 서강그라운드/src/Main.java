import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n+1][n+1];
        for(int index = 1; index <=n; index++){
            Arrays.fill(dist[index], 15*n);
            dist[index][index] = 0;
        }
        int[] items = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int index = 1; index <=n; index++){
            items[index] = Integer.parseInt(st.nextToken());
        }
        while(r-- >0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            dist[start][end] = distance;
            dist[end][start] = distance;
        }
        for(int index = 1; index <=n; index++){
            for(int x = 1; x <=n; x++){
                for(int y = 1; y <=n; y++){
                    dist[x][y] = Math.min(dist[x][y], dist[x][index] + dist[index][y]);
                }
            }
        }
        int result = 0;
        for(int x = 1; x <=n; x++){
            int sum = 0;
            for(int y = 1; y <=n; y++){
                if(dist[x][y] > m) continue;
                sum += items[y];
            }
            result = Math.max(sum, result);
        }
        System.out.println(result);
    }
}