import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N  = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] arr = new int [N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    int sum = arr[i]+arr[j]+arr[k];
                    if(sum > max && i!=j && j!=k && k!= i && sum <= M){
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
