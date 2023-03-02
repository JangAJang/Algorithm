import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        long max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
            max =Math.max(arr[i], max);
        }
        max++;
        long min = 0;
        long mid = 0;
        while(min < max){
            mid = (min+max)/2;
            long total_length = 0;
            for(int i=0; i<n; i++){
                long tmp = arr[i] - mid;
                if(tmp > 0) total_length += tmp;
            }
            if(total_length < m){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
