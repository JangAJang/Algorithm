import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] table = new int [N+1][K+1];
        for(int k=1; k<=K; k++){
            for(int i=1; i<=N; i++){
                table[i][k] = table[i-1][k];
                if(k - arr[i][0] >=0 ){
                    table[i][k] = Math.max(table[i-1][k], arr[i][1]+table[i-1][k-arr[i][0]]);
                }
            }
        }
        System.out.println(table[N][K]);
    }
}