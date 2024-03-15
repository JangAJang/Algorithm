import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final long DIVIDER =1_000_000_007;
    private static long answer = 0;
    private static final long[] cases = new long[300_001];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        cases[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
            if(index > 0) cases[index] = (cases[index-1] * 2) % DIVIDER;
        }
        Arrays.parallelSort(arr);

        for(int index = 0; index < n; index++) {
            answer += (cases[index] - cases[n - index-1]) * arr[index];
            answer %= 1000000007;
        }

        System.out.println(answer);
    }
}