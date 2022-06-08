import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long max = 0;
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        long shortest = 1;
        long longest = arr[n-1] - arr[0] + 1;
        while(shortest < longest){
            long mid = (shortest+longest)/2;
            if(InternetConnector(arr, mid) >= c){
                shortest = mid+1;
            }
            else{
                longest = mid;
            }
        }
        System.out.println(shortest-1);
    }

    static long InternetConnector(long[] arr, long distance){
        int count = 1;
        long lastlocation = arr[0];
        for(int i=1; i<arr.length; i++){
            long locate = arr[i];
            if(locate - lastlocation >= distance){
                count++;
                lastlocation = locate;
            }
        }
        return count;
    }
}
