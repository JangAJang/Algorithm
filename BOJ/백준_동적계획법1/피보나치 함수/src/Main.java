import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[42];
        arr[0] = 1;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        for(int i=0; i<T; i++){
            int X = Integer.parseInt(br.readLine());
            for(int j=4; j<X+2; j++){
                arr[j] = arr[j-1]+arr[j-2];
            }
            System.out.println(arr[X] + " " + arr[X+1]);
        }
    }
}
