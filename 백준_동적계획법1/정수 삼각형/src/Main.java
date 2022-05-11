import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static StringTokenizer st;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        getNumbers();
        for(int i=0; i<N; i++){
            max = Math.max(arr[N-1][i], max);
        }
        System.out.println(max);
    }

    static void getNumbers()throws IOException{
        arr[0][0] = Integer.parseInt(br.readLine());
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(j == 0) arr[i][j] = arr[i-1][j] + tmp;
                else if(j == i) arr[i][j] = arr[i-1][j-1] + tmp;
                else arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + tmp;
            }
        }
    }
}
