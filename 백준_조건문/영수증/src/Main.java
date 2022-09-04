import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long total = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long price = Long.parseLong(st.nextToken());
            long count = Long.parseLong(st.nextToken());
            total -= price * count;
        }
        if(total == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
