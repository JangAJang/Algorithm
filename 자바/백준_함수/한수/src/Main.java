import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i<=T; i++){
            count += has(i);
        }
        System.out.println(count);
    }

    static int has(int a) {
        int x=0;
        if(a<100) x= 1;
        else if( a>= 100 && a<1000) {
            if( (a/100 - (a/10)%10) == (((a/10)%10) - a%10)) x= 1;
        }
        else x= 0;
        return x;
    }
}
