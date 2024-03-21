import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Silver2. 1699 제곱수의 합
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;
        for(int index = 1; index <= Math.sqrt(n); index++) {
            arr[index*index] = 1;
        }

        for(int index = 2; index <=n; index++) {
            for(int divider = 1; divider < index; divider++) {
                arr[index] = Math.min(arr[index], arr[index - divider] + arr[divider]);
            }
        }
        System.out.println(arr[n]);
    }
}