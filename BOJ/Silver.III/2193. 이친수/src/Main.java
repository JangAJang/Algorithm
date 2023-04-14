import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int x = Integer.parseInt(br.readLine());
        long[] dp = new long[x+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int each = 3; each <= x; each++){
            dp[each] = dp[each-1] + dp[each-2];
        }
        System.out.println(dp[x]);
    }
}