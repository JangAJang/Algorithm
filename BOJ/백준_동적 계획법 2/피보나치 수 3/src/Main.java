import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static final int[] GIVEN = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] fibonacci = new int[1_500_001];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        long n = Long.parseLong(br.readLine());
        for(int index = 2; index <= 1_500_000; index++){
            fibonacci[index] = (fibonacci[index-1] + fibonacci[index-2]) % 1_000_000;
        }
        int index = (int)(n % 1_500_000);
        System.out.println(fibonacci[index]);
    }

}