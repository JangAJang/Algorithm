import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] weight = new int[T], height = new int[T], rate = new int[T];
        for (int i = 0; i < T; i++) {
            rate[i] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<T; i++){
            for(int j=0; j<T; j++){
                if(weight[i] < weight[j] && height[i] <height[j]) rate[i]++;
            }
            rate[i]++;
            System.out.print(rate[i]+" ");
        }
        System.out.println();
    }
}