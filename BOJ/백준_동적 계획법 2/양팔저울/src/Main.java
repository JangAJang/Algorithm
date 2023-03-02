import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new boolean[31][15001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        find(0, 0);
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while(m-->0){
            int x = Integer.parseInt(st.nextToken());
            if(x > 15000) sb.append("N ");
            else sb.append(dp[n][x]?"Y " : "N ");
        }
        System.out.println(sb);
    }

    public static void find(int index, int weight){
        if(dp[index][weight]) return;
        dp[index][weight] = true;
        if(index==n) return;
        find(index+1, weight+arr[index+1]);
        find(index+1, weight);
        find(index+1, Math.abs(weight-arr[index+1]));
    }
}
