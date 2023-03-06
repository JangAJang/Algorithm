import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            checkStickerCase();
        }
    }

    private static void checkStickerCase()throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n+1];
        int[][] dp = new int[2][n+1];
        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int index = 1; index <= n; index++){
            arr[0][index] = firstLine[index-1];
            arr[1][index] = secondLine[index-1];
        }
        for(int index = 1; index <=n; index++){
            dp[0][index] = Math.max(dp[0][index-1], dp[1][index-1] + arr[0][index]);
            dp[1][index] = Math.max(dp[1][index-1], dp[0][index-1] + arr[1][index]);
        }
        System.out.println(Math.max(dp[0][n], dp[1][n]));
    }
}