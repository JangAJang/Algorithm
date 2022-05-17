import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long count5(int num) {
        long tmp =0;
        if (num<5) return 0;
        for (long i=5;i<=num;i=i*5) {
            tmp= tmp+ (num/i);
        }
        return tmp;
    }

    public static long count2(int num) {
        long tmp =0;
        if (num<2) return 0;
        for (long i=2;i<=num;i=i*2) {
            tmp=tmp+ (num/i);
        }
        return tmp;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long result_of_2 = count2(n) - count2(n-m) - count2(m);
        long result_of_5 = count5(n) - count5(m) - count5(n-m);
        System.out.println(Math.min(result_of_2, result_of_5));
    }
}
