import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long[][] result = PoweredMatrix(n, b, arr);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static long[][] PoweredMatrix(long n, long b, long[][] arr){
        if(b == 2) return arr;
        else{
            if(b%2 == 0){
                return solution(PoweredMatrix(n, b/2, arr), PoweredMatrix(n, b/2, arr));
            }
            else {
                return solution(PoweredMatrix(n, b-1, arr), arr);
            }
        }
    }

    public static long[][] solution(long[][] arr1, long[][] arr2) {
        long[][] answer = new long[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                for (int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] = (answer[i][j] + arr1[i][k] * arr2[k][j])%1000;
                }
            }
        }
        return answer;
    }
}
