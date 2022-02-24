import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int counter = 0;
        for(int k=0; k<N; k++) {
            int x = Integer.parseInt(st.nextToken());
            boolean sosu = true;
            if (x == 1) sosu = false;
            for (int i = 2; i < x; i++) {
                if (x % i == 0 && x / i != 1) sosu = false;
            }
            if (sosu == true) counter++;
        }
        System.out.println(counter);
    }
}
