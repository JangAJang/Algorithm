import java.io.*;

public class Main {
    private static final int MOD = 1000000000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static long[][][] dp;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++)
            dp[1][i][1 << i] = 1;

        for (int n = 2; n <= N; n++) {
            for (int k = 0; k <= 9; k++) {
                for (int visit = 0; visit < (1 << 10); visit++) {
                    int newVisit = visit | (1 << k);
                    adjustNextValue(visit, n, k);
                    dp[n][k][newVisit] %= MOD;
                }
            }
        }

        long sum = 0;
        
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i][(1 << 10) - 1] % MOD;
            sum %= MOD;
        }

        System.out.println(sum);
    }

    private static void adjustNextValue(int visit, int n, int k) {
        int newVisit = visit | (1 << k);

        if (k == 0) {
            dp[n][k][newVisit] += dp[n - 1][k + 1][visit] % MOD;
            return;
        }

        if (k == 9) {
            dp[n][k][newVisit] += dp[n - 1][k - 1][visit] % MOD;
            return;
        }

        dp[n][k][newVisit] += dp[n - 1][k + 1][visit] % MOD + dp[n - 1][k - 1][visit] % MOD;
    }

}