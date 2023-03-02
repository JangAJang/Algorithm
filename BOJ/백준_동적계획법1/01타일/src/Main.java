import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<=N; i++){
            arr[i] = (arr[i-2]+arr[i-1]) %15746;
        }
        System.out.println(arr[N]);
    }
}