import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long p = 1000000007;

    static void getCoefficient(long n, long k){
        long top = getFactorial(n) % p;
        long bot = (getFactorial(k) * getFactorial(n-k)) % p;
        long bot_result = power(bot, p-2);
        System.out.println( (top * bot_result) % p );
    }

    static long power(long base, long num){
        if(num == 1) return base % p;
        long tmp = power(base, num/2);
        if(num % 2 == 1){
            return (((tmp*tmp) % p) * base) % p;
        }
        return (tmp * tmp) % p;
    }

    static long getFactorial(long x){
        long result = 1;
        for(long i = 1; i<=x; i++){
            result = (result * i) % p;
        }
        return result;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  =new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        getCoefficient(n, k);
    }
}
