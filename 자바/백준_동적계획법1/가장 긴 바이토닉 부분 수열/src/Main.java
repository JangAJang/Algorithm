import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[A];
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] countf = new int[A], countb = new int[A];
        for(int i=0; i<A; i++){
            countf[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]) countf[i] = Math.max(countf[j]+1, countf[i]);
            }
        }
        for(int i=A-1; i>=0; i--){
            countb[i] = 1;
            for(int j=A-1; j >=0; j--){
                if(arr[i] > arr[j]) countb[i] = Math.max(countb[j]+1, countb[i]);
            }
        }
        int max = 0;
        for(int i=0; i<A; i++){
            max = Math.max(max, countf[i]+countb[i]);
        }
        System.out.println(max-1);
    }
}