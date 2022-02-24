import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while( a!=0&&b!=0&&c!=0) {
            int max, min1, min2;
            if (a > b && a > c) {
                max = a;
                min1 = b;
                min2 = c;
            } else if (b > a && b > c) {
                max = b;
                min1 = a;
                min2 = c;
            } else {
                max = c;
                min1 = a;
                min2 = b;
            }
            if (max * max == min1 * min1 + min2 * min2) System.out.println("right");
            else System.out.println("wrong");
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
