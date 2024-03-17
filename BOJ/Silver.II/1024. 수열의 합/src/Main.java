import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX_LENGTH = 100;

    public static void main(String[] args) throws IOException {
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = findLength(n, Integer.parseInt(st.nextToken()));

        if (length > 0) {
            int a = (2 * n - length * (length - 1)) / (2 * length);
            for (int i = 0; i < length; i++) {
                System.out.print((a + i) + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static int findLength (final int n, final int length) {
        for (int l = length; l <= MAX_LENGTH; l++) {
            int a = (2 * n - l * (l - 1)) / (2 * l);
            if (a < 0) continue;
            if (a * l + (l * (l - 1) / 2) == n) {
                return l;
            }
        }
        return -1;
    }
}