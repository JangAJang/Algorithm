import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);
        for(int x = 2; x <=n; x++){
            for(int y = 0; y < 10; y++){
                for(int i = y; i < 10; i++){
                    dp[x][y] = (dp[x-1][i] + dp[x][y])%10007;
                }
            }
        }
        System.out.println(Arrays.stream(dp[n]).sum() % 10007);
    }
}