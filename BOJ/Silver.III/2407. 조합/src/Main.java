import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        BigInteger n = BigInteger.ONE;
        BigInteger r = BigInteger.ONE;
        for (int i = 0; i < R; i++) {
            n = n.multiply(new BigInteger(String.valueOf(N - i)));
            r = r.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(n.divide(r));
    }
}