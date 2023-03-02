import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int [n+1][2];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) return -1;
                else if(o1[0] > o2[0]) return 1;
                else return 0;
            }
        });
        int[] dp = new int[n+1];
        int max = 0;
        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[i][1] > arr[j][1]) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(n-max);
    }
}