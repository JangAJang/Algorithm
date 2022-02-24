import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int devide=2;
        while(N>1){
            if(N%devide == 0){
                N/=devide;
                System.out.println(devide);
            }
            else devide++;
        }
    }
}
