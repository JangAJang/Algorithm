import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        long K;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Long.parseLong(br.readLine());
        long[] arr = new long[(int)K];
        long count = 0;
        long sum = 0;
        for(long k = 0; k<K; k++){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                count--;
                sum -= arr[(int)count];
            }
            else{
                arr[(int)count] = num;
                sum += num;
                count++;
            }
        }
        System.out.println(sum);
    }
}
