import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, 50_000);
        dp[0] = 0;
        for(int index = 1; index <=n; index++){
            double squared = Math.sqrt(index);
            if((int)squared == squared){
                dp[index] = 1;
                continue;
            }
            for(int part = 1; part <= squared; part++){
                int partValue = (int)Math.pow(part, 2);
                dp[index] = Math.min(dp[index], dp[partValue]+dp[index - partValue]);
            }
        }
        System.out.println(dp[n]);
    }
}