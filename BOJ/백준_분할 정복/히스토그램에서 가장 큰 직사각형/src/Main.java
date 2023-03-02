import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(getMaxWidth(arr, 0, n-1));
    }

    public static long getMaxWidth(long[] arr, int start, int end){
        if(start == end) return arr[start];
        else{
            int mediun = (start+end)/2;
            long num1 = getMaxWidth(arr, start, mediun);
            long num2 = getMaxWidth(arr, mediun+1, end);
            long height = Long.MAX_VALUE;
            for(int i=start; i<=end; i++){
                height = Math.min(height, arr[i]);
            }
            long num3 = height * (start-end);
            return Math.max(num3, Math.max(num1, num2));
        }
    }
}
