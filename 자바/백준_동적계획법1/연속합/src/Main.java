import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];
        int max=0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0) {sum[i] = arr[i]; max = arr[i];}
            else{
                sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
            }
            max = Math.max(sum[i], max);
        }
        System.out.println(max);
    }
}