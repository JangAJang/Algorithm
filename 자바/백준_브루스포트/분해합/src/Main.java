import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // N = a + 100*a + b + 1*b + c + c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int min = N;
        for(int i=1; i<N; i++){
            String number = Integer.toString(i);
            int sum = i;
            for(int j=0; j<number.length(); j++){
                sum +=Character.getNumericValue(number.charAt(j));
            }
            if(sum == N && i < min ) min =i;
        }
        if(min == N) System.out.println(0);
        else System.out.println(min);
    }
}
