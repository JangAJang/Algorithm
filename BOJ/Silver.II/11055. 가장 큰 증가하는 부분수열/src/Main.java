import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Silver2. 11055 가장 긴 증가하는 부분수열
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int[] arr = new int[n];
        for(int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
            dp[index][index] = arr[index];
        }

        for(int x = n-1; x >=0; x--) {
            for(int y = x+1; y < n; y++) {
                if(arr[x] < arr[y]) { // 수열에 추가해야 하는 경우
                    dp[x][y] = dp[x+1][y] + arr[x];
                    continue;
                }
                dp[x][y] = Math.max(Math.max(dp[x][y-1], arr[x]), dp[x+1][y]);
            }
        }
        System.out.println(dp[0][n-1]);
    }
}