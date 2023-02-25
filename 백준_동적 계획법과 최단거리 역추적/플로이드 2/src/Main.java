import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] field = new int[n+1][n+1];
        for(int x = 1; x <=n; x++){
            for(int y = 1; y <= n; y++){
                if(x == y) {
                    field[x][y] = 0;
                    continue;
                }
                field[x][y] = 100_000_000;
            }
        }
        for(int index = 0; index < edges; index++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            field[a][b] = Math.min(field[a][b], c);
        }
        printResult(field, n);
        
    }

    private static void printResult(int[][] field, int n){
        for(int j = 1; j <=n; j++){
            for(int x = 1; x <=n; x++){
                for(int y = 1; y <=n; y++){
                    field[x][y] = Math.min(field[x][y], field[x][j] + field[j][y]);
                }
            }
        }
        for(int x = 1; x <=n; x++){
            for(int y = 1; y <=n; y++){
                System.out.print(field[x][y] + " ");
            }
            System.out.println();
        }
    }
}