
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static long n;
    static long k;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        long start = 1;
        long end = k;
        while(start < end){
            long mid = (start+end)/2;
            long count = 0;
            for(int i=1; i<=n; i++){
                count += Math.min(mid/i, n);
            }
            if(k <= count){
                end = mid;
            }
            else start = mid+1;
        }
        System.out.println(start);
    }
}
