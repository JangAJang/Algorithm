import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int radius = Integer.parseInt(br.readLine());
        double circle = Math.PI*radius*radius;
        double taxi = 2*radius*radius;
        System.out.println(String.format("%.6f", circle));
        System.out.println(String.format("%.6f", taxi));
    }
}
