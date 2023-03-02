import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long divider = 1000000000;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N+1][10];
        long result=0;
        for(int i=0; i<10; i++){
            arr[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            arr[i][0] = arr[i-1][1]%divider;
            arr[i][9] = arr[i-1][8]%divider;
            for(int j=1; j<=8; j++){
                arr[i][j] = (arr[i-1][j-1]%divider + arr[i-1][j+1]%divider)%divider;
            }
        }
        for(int i=1; i<=9; i++){
            result =(result+arr[N][i]%divider)%divider;
        }
        System.out.println(result);
    }
}
