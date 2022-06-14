import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        while(task-- > 0){
            int N = sc.nextInt();
            int[] arr = new int[N+1];
            int[][] dp = new int[N+1][N+1];
            int[] sum = new int[N+1];
            for(int i=1; i<=N; i++){
                arr[i] = sc.nextInt();
                sum[i] = sum[i-1] + arr[i];
            }
            for(int i=1; i<=N-1; i++){
                for(int from = 1; from + i <= N; from++){
                    int to = from + i;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divider = from; divider < to; divider++){
                        dp[from][to] = Math.min(dp[from][to], dp[from][divider] + dp[divider+1][to] + sum[to] - sum[from-1]);
                    }
                }
            }
            System.out.println(dp[1][N]);
        }
    }
}
