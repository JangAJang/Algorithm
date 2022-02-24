import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int [4], y = new int[4];
        x[3] = 0; y[3] = 0;
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Resulting(x);
        Resulting(y);
        System.out.println(x[3]+" "+y[3]);
    }
    static void Resulting(int[] x){
        for(int i=0; i<3; i++){
            int count=0;
            for(int j=0; j<3; j++){
                if(x[i] == x[j]) count++;
            }
            if(count == 1) x[3] = x[i];
        }
    }
}
