import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for(int index = 3; index <=n; index++){
            dp[index] = (dp[index-1] + dp[index-2]*2)%10_007;
        }
        System.out.println(dp[n]);
    }
}