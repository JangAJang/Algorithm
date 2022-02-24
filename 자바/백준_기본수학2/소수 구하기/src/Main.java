import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = Integer.parseInt(st.nextToken()), max = Integer.parseInt(st.nextToken());
        for(int x = min; x<=max; x++) {
            boolean check=true;
            if(x==1)check = false;
            else if(x==2) check = true;
            else for (int i = 2; i <= Math.sqrt(x); i++) {
                if(x%i == 0) { check = false; break;}
            }
            if(check) System.out.println(x);
        }
    }
}
