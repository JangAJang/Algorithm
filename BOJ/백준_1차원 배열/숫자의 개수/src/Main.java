import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[3];
        int res = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(br.readLine());
            res *= arr[i];
        }
        for(int c=0; c<10; c++){
            int tmp = res;
            int count = 0;
            for(int i=10; tmp>=1; i*=10){
                if(tmp % 10 == c) count++;
                tmp /=10;

            }
            System.out.println(count);
        }
    }
}
