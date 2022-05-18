import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int getTotal(int[] arr, int n, int i){
        int result = 0;
        for(int k=0; k<n;k++){
            result += arr[k+i];
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N-K+1; i++){
            max = Math.max(max, getTotal(arr, K, i));
        }
        System.out.println(max);
    }
}
