import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for(int qwe = 0; qwe<C; qwe++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int avg = 0;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                avg += arr[i];
            }
            avg /= N;
            double count = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > avg) count++;
            }
            count = count / N * 100;
            System.out.println(String.format("%.3f", count) + "%");
        }
    }
}
