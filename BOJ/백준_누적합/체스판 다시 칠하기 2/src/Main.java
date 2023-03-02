import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 체스판 다시 칠하기

    private static int n, m, k;
    private static char[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        chessBoard = new char[n][m];
        for(int indexX = 0; indexX <n; indexX++){
            String eachLine = br.readLine();
            for(int indexY = 0; indexY < m; indexY++){
                chessBoard[indexX][indexY] = eachLine.charAt(indexY);
            }
        }
        System.out.println(Math.min(findMinimalCountToMakeBoard('B'), findMinimalCountToMakeBoard('W')));
    }

    private static int findMinimalCountToMakeBoard(char color){
        int[][] countedSum = new int[n+1][m+1];
        int value;
        for(int indexX =0; indexX < n; indexX++){
            for(int indexY = 0; indexY <m; indexY++){
                    value = makeValue(indexX, indexY, color);
                    countedSum[indexX + 1][indexY + 1] = countedSum[indexX][indexY + 1]
                            + countedSum[indexX + 1][indexY] - countedSum[indexX][indexY] + value;
            }
        }
        int minimumCount = Integer.MAX_VALUE;
        for(int indexX = 1; indexX <= n-k+1; indexX++){
            for(int indexY = 1; indexY <=m-k+1; indexY++){
                minimumCount = Math.min(minimumCount, countedSum[indexX+k-1][indexY+k-1] - countedSum[indexX+k-1][indexY-1] - countedSum[indexX-1][indexY+k-1] + countedSum[indexX-1][indexY-1]);
            }
        }
        return minimumCount;
    }

    private static int makeValue(int indexX, int indexY, char color){
        if((indexX+indexY)%2 == 0) return chessBoard[indexX][indexY] != color ? 1:0;
        return chessBoard[indexX][indexY] == color ? 1:0;
    }
}