import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int INF = 1_000 * 1_000;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] cases = new int[n+1][3];
        int[][] dp = new int[n+1][3];
        for(int i = 1 ; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                cases[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = INF;
        for(int k = 0; k < 3; k++) {
            for(int i = 0 ; i < 3; i++) {
                if(i == k) {
                    dp[1][i] = cases[1][i];
                    continue;
                }
                dp[1][i] = INF;
            }
            for (int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cases[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cases[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cases[i][2];
            }
            for(int i = 0 ; i < 3; i++)
                if(i != k) answer = Math.min(answer, dp[n][i]);
        }
        System.out.println(answer);
    }
}