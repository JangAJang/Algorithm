import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] total = new long[n+1];
        long max = 0;
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n>=1)total[1] = arr[1];
        if(n>=2)total[2] = total[1]+arr[2];
        if(n>=3)total[3] = Math.max(total[2], Math.max(arr[3]+arr[1], arr[3]+arr[2]));
        for(int i=4; i<=n; i++){
            total[i] = Math.max(total[i-1], Math.max(total[i-2]+arr[i], total[i-3]+arr[i]+arr[i-1]));
        }
        System.out.println(total[n]);
    }
}
