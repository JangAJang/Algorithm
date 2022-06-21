import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] c = new int[n+1] ;
        long[][] dp = new long[n+1][10001];
        int result=Integer.MAX_VALUE;
        st =new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st2.nextToken());
        }
        for(int i=1; i<=n; i++){
            for(int j=0; j<= 10000; j++){
                if(i==1 && j>= c[i]) dp[i][j] = arr[i];
                else{
                    if(j >= c[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + arr[i]);
                    else dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= m) result = Math.min(j, result);
            }
        }
        System.out.println(result);
        
    }
}
