import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[] check = new boolean[10];
    static int[] numbers = new int [10];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, N, M);
    }

    static void dfs(int index, int N, int M){
        if(index == M) {
            boolean checker = true;
            for(int i=0; i<M-1; i++){
                if(numbers[i] > numbers[i+1]) checker = false;
            }
            for(int value : numbers) {
                if(value != 0 && checker) System.out.print(value + " ");
            }
            if(checker)System.out.println();
            return ;
        }

        for (int i = 1; i <= N; i++) {
            if(check[i]) continue;
            check[i] = true;
            numbers[index] = i;
            dfs(index + 1, N, M);
            check[i] = false;
        }
    }
}
