import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int recall_count = 1;
    static int dp_count = 0;

    static int recallingFibonacci(int n){
        if(n==1 || n == 2) return 1;
        else {
            recall_count++;
            return recallingFibonacci(n-1) + recallingFibonacci(n-2);
        }
    }

    static void dpFibonacci(int n){
        arr = new int[50];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1] + arr[i-2];
            dp_count++;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        recallingFibonacci(n);
        dpFibonacci(n);
        System.out.println(recall_count + " " + dp_count);
    }
}
