import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        char T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine().charAt(0);
        System.out.println((int)T);
    }
}