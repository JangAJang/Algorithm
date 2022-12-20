import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] board = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int papers = Integer.parseInt(bufferedReader.readLine());
        while(papers-->0){
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            checkSquare(x, y);
        }
        System.out.println(Arrays.stream(board).mapToInt(s-> (int)Arrays.stream(s).filter(value-> value == 1).count()).sum());
    }

    private static void checkSquare(int x, int y){
        for(int indexX = x; indexX < 10+x; indexX++){
            for(int indexY = y; indexY < 10 +y; indexY++){
                board[indexX][indexY] = 1;
            }
        }
    }

}