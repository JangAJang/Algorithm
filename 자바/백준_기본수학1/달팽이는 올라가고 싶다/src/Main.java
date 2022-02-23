import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
        int moveaday = A-B;
        int should = V - A;
        int days = should / moveaday;
        if(should % moveaday > 0) days++;
        System.out.println(++days);
    }
}
