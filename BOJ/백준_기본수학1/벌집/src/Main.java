import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = 1;
        System.out.println(layer(N));

    }
    static int layer(int n){
        if(n == 1) return 1;
        int layer = 1;
        int number = 2;
        while(number <= n){
            number = number + layer*6;
            layer++;
        }
        return layer;
    }
}

