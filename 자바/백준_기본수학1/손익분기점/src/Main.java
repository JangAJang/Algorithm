import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
        int bep = 0;
        int profit = C-B;
        for(int i=0; A >= profit*bep ; i++){
            if(profit<=0) { bep = -1; break;}
            bep++;
        }
        System.out.println(bep);
    }
}
