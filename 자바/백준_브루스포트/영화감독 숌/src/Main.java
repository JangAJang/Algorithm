import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int counter=0;
        int x=666;
        while(counter <N){
            if(String.valueOf(x).contains("666")) {
                counter++;
            }
            x++;
        }
        System.out.println(x-1);
    }
}
