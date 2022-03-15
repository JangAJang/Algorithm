import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        int[] count = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count[0] = 1;
        for(int i=1; i<A; i++){
            count[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && count[i] <= count[j]) count[i] = count[j]+1;
            }
        }
        int max =0;
        for(int i : count){
            max = Math.max(i, max);
        }
        System.out.println(max);
    }
}
