import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        double length = Math.sqrt(W*W + H*H);
        for(int i=0; i<N; i++){
            int task = Integer.parseInt(br.readLine());
            if(length >= task) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
