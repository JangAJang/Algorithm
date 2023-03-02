import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long count = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        long[] sum = new long[N+1];
        long[] rest = new long[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
            if(sum[i]%M==0) count++;
            rest[(int)(sum[i]%M)]++;
        }
        for(int i=0; i<M; i++){
            count += rest[i]*(rest[i]-1)/2;
        }
        System.out.println(count);
    }
}
