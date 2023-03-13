import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] x = new long[n + 1];
        long[] y = new long[n + 1];
        for (int index = 0; index < n; index++) {
            long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            x[index] = inputs[0];
            y[index] = inputs[1];
        }
        x[n] = x[0];
        y[n] = y[0];
        long sumA = 0L;
        long sumB = 0L;

        for (int i = 0; i < n; i++) {
            sumA += x[i] * y[i + 1];
            sumB += x[i + 1] * y[i];
        }
        System.out.printf("%.1f\n", (Math.abs(sumA - sumB)/2.0));
    }
}