import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int shack=-1;
        int count=0;
        for(int i=0; i<1001; i++){
            for(int j=0; j<1667; j++){
                if(T == 5*i + 3*j) { shack = i+j; break;}
            }
        }
        System.out.println(shack);
    }
}
