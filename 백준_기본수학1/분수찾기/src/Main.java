import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        int line = 0;
        while(true){
            line++;
            count +=line;
            if(count >= X){
                if(line %2 == 0)System.out.println((X-count+line) + "/"+(count-X+1));
                else System.out.println((count-X+1) + "/"+(X-count+line));
                break;
            }

        }
    }
}
