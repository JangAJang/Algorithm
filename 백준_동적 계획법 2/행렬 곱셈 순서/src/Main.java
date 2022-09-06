import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] data = new int[count+1];
        StringTokenizer st;
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine(), " ");
            data[i] = Integer.parseInt(st.nextToken());
            data[i+1] = Integer.parseInt(st.nextToken());

        }
        int[][] dp = new int[count][count];
        for(int i=2; i<count+1; i++){
            for(int j=0; j<count-1+i; j++){
                dp[i][j+i-1] = Integer.MAX_VALUE;
                for(int k=j; k<j+i-1; k++){
                    int value = dp[j][k]  + dp[k+1][j+i-1] + (data[j]*data[k+1]*data[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
                }
            }
        }
        System.out.println(dp[0][count-1]);
    }
}
