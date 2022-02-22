import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;
        for(int i=0; i<numbers.length(); i++){
            sum += Character.getNumericValue(numbers.charAt(i));
        }
        System.out.println(sum);
    }
}
