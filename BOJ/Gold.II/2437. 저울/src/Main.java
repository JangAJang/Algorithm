import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // Gold2. 2437 저울


    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] inputs = br.readLine().split(" ");
        int sum = 0;
        for(int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(inputs[index]);
            sum += arr[index];
        }
        Arrays.sort(arr);
        System.out.println(findUnreachableSum(sum, n));
    }

    private static int findUnreachableSum(final int sum,  final int n) {

        int accumulated = 0;

        for(int index = 0; index < n; index++) {
            if(accumulated +1 < arr[index]) {
                return accumulated+1;
            }

            accumulated += arr[index];
        }

        return sum+1;
    }
}