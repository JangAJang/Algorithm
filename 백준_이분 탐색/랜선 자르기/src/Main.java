import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //시간초과

    static int n;
    static int k;
    static long[] arr;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new long[k];
        long leastLength = Long.MAX_VALUE;
        for(int i=0; i<k; i++){
            arr[i] = Long.parseLong(br.readLine());
            leastLength = Math.min(leastLength, arr[i]);
        }
        System.out.println(getMaximizedLength(0, leastLength));
    }

    static long getMaximizedLength(long start, long end){
        long mid =(start+end)/2;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i] / mid;
        }
        if(sum == n) return mid;
        else if(sum < n){
            return getMaximizedLength(start, mid);
        }
        else return getMaximizedLength(mid+1, end);
    }
}
