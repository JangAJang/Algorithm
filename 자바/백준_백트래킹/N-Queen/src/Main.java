import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int N;
    static int[] chessMap;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chessMap = new int[N];
        cnt = 0;
        dfs(0);
        System.out.println(cnt);
        br.close();
    }
    private static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            chessMap[depth] = i;
            if (possible(depth)) {
                dfs(depth + 1);
            }
        }
    }
    private static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (chessMap[col] == chessMap[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(chessMap[col] - chessMap[i])) {
                return false;
            }
        }
        return true;
    }
}