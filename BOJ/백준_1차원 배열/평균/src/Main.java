import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int [T];
        double avg = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<arr.length; i++){
            avg += arr[i];
            if(max < arr[i]) max = arr[i];
        }
        avg = avg/max/T * 100;
        System.out.println(avg);
    }
}
