import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void getResult(int a, int b){
        int min = Math.min(a, b);
        int gcd = 0;
        for(int i=1;i<=min; i++){
            if(a%i==0 && b%i==0) gcd = i;
        }
        System.out.println(a/gcd + "/" + b/gcd);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<T; i++){
            if(i==0) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            else{
                arr[i] = Integer.parseInt(st.nextToken());
                getResult(arr[0], arr[i]);
            }
        }
    }
}
