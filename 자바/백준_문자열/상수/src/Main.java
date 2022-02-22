import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
        int A = (a/100) + ((a/10)%10)*10 + (a%10)*100;
        int B = b/100 + ((b/10)%10)*10 + 100*(b%10);
        if(A>B) System.out.println(A);
        if(A<B) System.out.println(B);
    }
}
