import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[] dp = new int[price+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        int[] coins = new int[n];
        for(int index = 0; index < n; index++){
            coins[index] = Integer.parseInt(br.readLine());

        }for(int i=0;i<n;i++){
            for(int j = coins[i];j<=price;j++){
                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if(dp[price] == Integer.MAX_VALUE-1) dp[price] = -1;
        System.out.println(dp[price]);
    }
}