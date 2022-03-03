import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int n = Integer.parseInt(N);
        int[] arr = new int[N.length()];
        for(int i=0; i<N.length(); i++){
            arr[i] = n%10;
            n/=10;
        }
        Arrays.sort(arr);
        for(int i=N.length()-1; i>=0; i--){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
