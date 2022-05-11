import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char [][]b_origin = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };
    static char [][]w_origin = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
    };
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        char[][] chess = new char [N][M];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                chess[i][j] = tmp.charAt(j);
            }
        }
        System.out.println(Counter(chess, N, M));
    }

    static int Counter(char[][] chess, int N, int M){
        int total = 64;
        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                int countW =0, countB=0;
                for(int x=0; x<8; x++){
                    for(int y=0; y<8; y++){
                        if(chess[i+y][j+x] != w_origin[y][x]) countW++;
                        if(chess[i+y][j+x] != b_origin[y][x]) countB++;
                    }
                }
                if(total > Math.min(countW, countB)) total = Math.min(countW, countB);
            }
        }
        return total;
    }
}
