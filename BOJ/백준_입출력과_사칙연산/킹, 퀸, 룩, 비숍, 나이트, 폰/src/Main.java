import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        int[] arr = {1, 1, 2, 2, 2, 8};
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< arr.length; i++){
            int x = Integer.parseInt(st.nextToken());
            sb.append(arr[i]-x + " ");
        }
        System.out.println(sb);
    }
}
