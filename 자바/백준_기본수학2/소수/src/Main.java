import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(br.readLine()), max = Integer.parseInt(br.readLine());
        int sum=0;
        int smallest=max;
        for(int k=min; k<=max; k++) {
            boolean sosu = true;
            if (k == 1) sosu = false;
            for (int i = 2; i < k; i++) {
                if (k % i == 0 && k / i != 1) sosu = false;
            }
            if (sosu == true) {
                sum += k;
                if(smallest > k) smallest = k;
            }
        }
        if(sum !=0) System.out.println(sum+"\n"+smallest);
        else System.out.println(-1);
    }
}
