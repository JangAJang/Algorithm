import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0) break;
            if( a % b == 0 ){
                System.out.println("multiple");
            }
            else if( b% a == 0){
                System.out.println("factor");
            }
            else System.out.println("neither");
        }
    }
}
