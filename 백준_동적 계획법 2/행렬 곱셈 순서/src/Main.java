import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            arr[i+1] = sc.nextInt();
        }
        for(int i=1; i<n; i++){
            for(int r = 1; r+i <= n; r++){
                int j = i+r;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
