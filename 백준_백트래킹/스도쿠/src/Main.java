import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] sudoku = new int [9][9];
    static int[] checker = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }

    static void dfs(int y, int x) throws IOException{
        if(x==9) {
            dfs(y+1, 0);
            return ;
        }
        if(y == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(sudoku[i][j]+" ");
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        if(sudoku[y][x] == 0){
            for(int i=1; i<=9; i++){
                if(check(y, x, i)) {sudoku[y][x] = i; dfs(y, x+1);}
            }
            sudoku[y][x] = 0;
            return ;
        }
        dfs(y, x+1);
    }

    static boolean check(int y, int x, int value){
        for(int i=0; i<9; i++){
            if(sudoku[y][i] == value) return false;
        }
        for(int i=0; i<9; i++){
            if(sudoku[i][x] == value) return false;
        }
        int boxX = (x/3)*3, boxY = (y/3)*3;
        for(int i=boxY; i<boxY+3; i++){
            for(int j=boxX; j<boxX+3; j++){
                if(sudoku[i][j] == value) return false;
            }
        }
        return true;
    }

}
