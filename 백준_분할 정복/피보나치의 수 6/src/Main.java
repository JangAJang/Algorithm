import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//현재 시간 초과
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] arr = {{1}, {0}};
        long[][] multiplier = { {1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());
        long[][] result = getFibonacciMultiplier(multiplier, n-1);
        result = solution(arr, result);
        System.out.println(result[0][0]);

    }

    public static long[][] getFibonacciMultiplier(long[][] mult, long n){
        if(n == 1){
            return mult;
        }
        else{
            if( n % 2 == 0){
                return solution(getFibonacciMultiplier(mult, n/2), getFibonacciMultiplier(mult, n/2));
            }
            else{
                return solution(mult, getFibonacciMultiplier(mult, n-1));
            }
        }
    }

    public static long[][] solution(long[][] arr1, long[][] arr2) {
        long[][] answer = new long[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                for (int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]) % 1000000007;
                }
            }
        }
        return answer;
    }
}
