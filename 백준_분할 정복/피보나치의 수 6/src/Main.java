import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] origin = { {1, 1}, {1, 0}};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] arr = { {1, 1}, {1, 0}};
        long n = Long.parseLong(br.readLine());
        if(n==0) System.out.println(0);
        else System.out.println(pow(arr, n-1)[0][0]);
    }
    public static long[][] pow(long[][] A, long exp) {
        if(exp == 1 || exp == 0) {
            return A;
        }
        long[][] ret = pow(A, exp / 2);
        ret = multiply(ret, ret);
        if(exp % 2 == 1L) {
            ret = multiply(ret, origin);
        }
        return ret;
    }

    public static long[][] multiply(long[][] arr1, long[][] arr2) {
        long[][] answer = new long[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2[0].length; ++j) {
                for (int k = 0; k < arr1[0].length; ++k) {
                    answer[i][j] += (arr1[i][k] * arr2[k][j]);
                    answer[i][j] %= 1000000007;
                }
            }
        }
        return answer;
    }
}

