import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long[][] dp;
    public static int[][] arr;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        arr = new int[length][2];
        dp = new long[length][length];
        for(int i=0; i<length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;

        }
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(i==j) dp[i][j] = 0;
                else dp[i][j] = Long.MAX_VALUE;
            }
        }
        for(int i=1; i<length; i++){
            for(int j=0; j+i<length; j++){
                calculate(j, j+i);
            }
        }
        System.out.println(dp[0][length-1]);
    }

    public static void calculate(int start, int end){
        for(int i= start; i< end; i++){
            long cost = dp[start][i] + dp[i+1][end] + (long) arr[start][0] * arr[i][1] * arr[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
    }
}
