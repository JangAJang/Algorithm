import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] money = new int [N];
        int[] count = new int [N];
        for(int i=0; i<N; i++){
            money[i] = Integer.parseInt(br.readLine());
            counter(money, count, i, K);
        }
        System.out.println(count[N-1]);
    }

    static void counter(int[] money, int[] count, int i, int K){
        if(money[i] > K) count[i] = count[i-1];
        else{
            int tmp = K;
            for(int k=i; k >=0; k--){
                count[i] += tmp/money[k];
                tmp = tmp%money[k];
            }
        }
    }
}