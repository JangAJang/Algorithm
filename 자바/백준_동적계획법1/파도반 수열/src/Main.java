import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long[] arr = new long[100];
    public static void main(String[] args) throws IOException {
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int X = Integer.parseInt(br.readLine());
            P(X);
        }
    }

    static void P(int n){
        if(n <3) System.out.println(1);
        else{
            for(int i=3; i<n; i++){
                arr[i] = arr[i-2]+arr[i-3];
            }
            System.out.println(arr[n-1]);
        }
    }
}