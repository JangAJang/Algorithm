import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        st  = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[1][i] = Integer.parseInt(st.nextToken())%3;
            if(arr[1][i]==0) count++;
        }
        for(int i=2; i<=N; i++){
            for(int j=N; j>=i; j--){
                arr[i][j] = (arr[i-1][j-1] + arr[1][j])%3;
                if(arr[i][j]==0) count++;
            }
        }
        System.out.println(count);
    }
}
